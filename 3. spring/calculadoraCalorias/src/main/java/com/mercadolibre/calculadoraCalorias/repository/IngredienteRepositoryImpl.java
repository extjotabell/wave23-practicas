package com.mercadolibre.calculadoraCalorias.repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadoraCalorias.entity.Ingredientes;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.List;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    private List<Ingredientes> ingredientes;

    private void loadData() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredientes>> typeReference = new TypeReference<>() {};
        List<Ingredientes> list = null;
        try {
            list = mapper.readValue(file, typeReference);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void test() {

    }
}
