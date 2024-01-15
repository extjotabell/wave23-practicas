package com.example.seguroAutos.utils;

import com.example.seguroAutos.dto.AutoDto;
import com.example.seguroAutos.model.Auto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class Mapper {
    private static final ObjectMapper mapper = new ObjectMapper() .registerModule(new JavaTimeModule());

    public static Auto autoDtoToAuto(AutoDto auto){
        return mapper.convertValue(auto, Auto.class);
    }
}
