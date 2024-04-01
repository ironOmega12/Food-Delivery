package com.foodappserver.foodserver.model.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodDao {
    @Autowired
    private FoodRepository repository;

    public Food save(Food food){
        return repository.save(food);
    }

    public List<Food> getAllFood(){
        List<Food> foods = new ArrayList<>();
        Streamable.of(repository.findAll())
                .forEach(foods::add);
        return foods;
    }

    public void delete(Food food){
        repository.delete(food);
    }
}
