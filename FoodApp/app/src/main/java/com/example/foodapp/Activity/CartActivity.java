package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.foodapp.Adapter.CartAdapter;
import com.example.foodapp.Domain.Foods;
import com.example.foodapp.Helper.ChangeNumberItemsListener;
import com.example.foodapp.Helper.ManagementCart;
import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityCartBinding;
import com.google.gson.Gson;

import org.checkerframework.checker.units.qual.C;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class CartActivity extends BaseActivity {

    private ActivityCartBinding binding;
    private RecyclerView.Adapter adapter;
    private ManagementCart managementCart;

    private double tax;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        managementCart = new ManagementCart(this);
        setVariable();
        calculateCart();
        initList();
        getWindow().setStatusBarColor(Color.parseColor("#282836"));
    }


    private void initList() {
        if(managementCart.getListCart().isEmpty()){
                binding.emptyTxt.setVisibility(View.VISIBLE);
                binding.scrollviewCart.setVisibility(View.GONE);
        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollviewCart.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.cardView.setLayoutManager(linearLayoutManager);
        adapter = new CartAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void change() {
                calculateCart();
            }
        });
        binding.cardView.setAdapter(adapter);
    }

    private void calculateCart() {
        double percentTax= 0.02; //procent 2% tva
        double delivery = 6; // 6lei transport

        tax = Math.round(managementCart.getTotalFee()*percentTax*100)/100;

        double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100) / 100;

        binding.totalTvaTxt.setText("RON" +itemTotal);
        binding.tvaTxt.setText("RON" +tax);
        binding.deliveryTxt.setText("RON" +delivery);
        binding.totalTxt.setText("RON" +total);
    }


    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
    }
}