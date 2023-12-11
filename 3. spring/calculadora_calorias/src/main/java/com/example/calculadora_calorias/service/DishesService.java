package com.example.calculadora_calorias.service;

import com.example.calculadora_calorias.dto.DishDTO;
import com.example.calculadora_calorias.repository.DishesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishesService implements com.example.calculadora_calorias.service.Service {

    private final DishesRepository dishesRepository;

    public DishesService(DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
    }

    @Override
    public Optional<DishDTO> findByName(String findParam) {
        return dishesRepository.findByName(findParam).map(DishDTO::new);
    }

    @Override
    public List<DishDTO> findManyByName(List<String> findParams) {
        return dishesRepository.findManyByName(findParams.stream()
                .map(String::toLowerCase).toList()).stream().map(DishDTO::new).toList();
    }
}
