package com.spring.calculadoracalorias.service.interfaces;

import com.spring.calculadoracalorias.dto.DishDto;

public interface IDishService {

    DishDto caloricReport(String name, int grams);
}
