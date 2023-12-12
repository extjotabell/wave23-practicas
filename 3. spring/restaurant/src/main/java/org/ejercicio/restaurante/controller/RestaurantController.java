package org.ejercicio.restaurante.controller;

import org.ejercicio.restaurante.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/restaurant/")
public class RestaurantController {

    @Autowired
    IRestaurantService restaurantService;

    @GetMapping("/{dishName}")
    public ResponseEntity<?> getAllInformationOfDish(@PathVariable String dishName) {
        return ResponseEntity.ok(restaurantService.getAllInformationOfDishName(dishName));
    }

}
