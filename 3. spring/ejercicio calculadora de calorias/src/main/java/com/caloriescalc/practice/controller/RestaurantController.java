package com.caloriescalc.practice.controller;

import com.caloriescalc.practice.dto.DishesDTO;
import com.caloriescalc.practice.request.RequestDish;
import com.caloriescalc.practice.request.RequestDishes;
import com.caloriescalc.practice.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {
    @Autowired
    IRestaurantService rs;

    @GetMapping (path = "/getDishes")
    ResponseEntity<?> getDishes (@RequestBody RequestDish dish) {
        try {
            return ResponseEntity.ok(rs.getData(dish));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Error " + e.getMessage());
        }
    }

    @GetMapping (path = "/getMultipleDishes")
    ResponseEntity<?> getMultipleDishes (@RequestBody RequestDishes dishes) {
        return ResponseEntity.ok(rs.getMultipleDishes(dishes));
    }
}
