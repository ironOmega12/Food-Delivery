package com.foodappserver.foodserver.controller;

import com.foodappserver.foodserver.model.food.Food;
import com.foodappserver.foodserver.model.food.FoodDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FoodController {

    @Autowired
    private FoodDao foodDao;

    @GetMapping("/food/get-all")
    public List<Food> getAllFood(){
        return foodDao.getAllFood();
    }

    @PostMapping("/food/save")
    public Food save(@RequestBody Food food){
        return foodDao.save(food);
    }
}
