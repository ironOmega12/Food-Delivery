package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.foodapp.Domain.FoodServer;
import com.example.foodapp.R;
import com.example.foodapp.Retrofit.FoodApi;
import com.example.foodapp.Retrofit.RetrofitService;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFoodsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_foods);
        
        initializeComponents();
    }

    private void initializeComponents() {
        EditText editText = findViewById(R.id.addItemText);
        Button addItemBtn = findViewById(R.id.addItemBtn);

        RetrofitService retrofitService = new RetrofitService();
        FoodApi foodApi = retrofitService.getRetrofit().create(FoodApi.class);

        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(editText.getText()); //item-ul care va fi trimis prin api la server
                FoodServer foodItem = new FoodServer();
                foodItem.setTitle(name);

                foodApi.save(foodItem)
                        .enqueue(new Callback<FoodServer>() {
                            @Override
                            public void onResponse(Call<FoodServer> call, Response<FoodServer> response) {
                                Toast.makeText(AddFoodsActivity.this, "Added successfully", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<FoodServer> call, Throwable t) {
                                Toast.makeText(AddFoodsActivity.this, "Add failed", Toast.LENGTH_SHORT).show();
                                Logger.getLogger(AddFoodsActivity.class.getName()).log(Level.SEVERE, "Error ocurred", t);
                            }
                        });
            }
        });
    }
}