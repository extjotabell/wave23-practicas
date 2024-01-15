package com.meli.sqlshowroom.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.sqlshowroom.repository.IClothesRepository;
import org.springframework.stereotype.Service;

@Service
public class ClothesServiceImpl implements IClothesService {

    private final IClothesRepository repository;
    private final ObjectMapper mapper = new ObjectMapper();

    public ClothesServiceImpl(IClothesRepository repository) { this.repository = repository; }

}
