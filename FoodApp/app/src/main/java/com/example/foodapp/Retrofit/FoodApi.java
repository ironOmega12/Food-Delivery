package com.example.foodapp.Retrofit;

import com.example.foodapp.Domain.FoodServer;
import com.example.foodapp.Domain.Foods;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface FoodApi {

    @GET("food/get-all")
    Call<List<FoodServer>> getAllFoods();

    @POST("food/save")
    Call<FoodServer> save(@Body FoodServer foodServer);
}
