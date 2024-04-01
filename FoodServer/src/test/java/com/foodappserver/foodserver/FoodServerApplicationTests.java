package com.foodappserver.foodserver;

import com.foodappserver.foodserver.model.food.Food;
import com.foodappserver.foodserver.model.food.FoodDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class FoodServerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private FoodDao foodDao;

	@Test
	void addFoodTest(){
		Food food = new Food();
		food.setTitle("burger");
		foodDao.save(food);
	}

//	@Test
//	void getAllFoodAndDelete(){
//		List<Food> foods = foodDao.getAllFood();
//		for(Food fd: foods){
//			foodDao.delete(fd);
//		}
//	}

}
