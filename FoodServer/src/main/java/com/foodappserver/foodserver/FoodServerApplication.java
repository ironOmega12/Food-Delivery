package com.foodappserver.foodserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.foodappserver.foodserver")
@EnableAutoConfiguration
public class FoodServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodServerApplication.class, args);
	}

}
