package com.foodappserver.foodserver.model.food;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends CrudRepository<Food, Integer> {

}
