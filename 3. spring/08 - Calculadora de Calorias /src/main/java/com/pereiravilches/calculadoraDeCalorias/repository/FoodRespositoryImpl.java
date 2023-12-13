package com.pereiravilches.calculadoraDeCalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pereiravilches.calculadoraDeCalorias.entity.Ingrediente;
import com.pereiravilches.calculadoraDeCalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRespositoryImpl implements IFoodRepository {
    ObjectMapper om = new ObjectMapper();
    List<Ingrediente> ingredienteList;
    List<Plato> platoList = new ArrayList<>();

    public FoodRespositoryImpl() throws IOException {
        this.ingredienteList = leerJson();
        cargarPlatos();
    }

    @Override
    public Plato findPlatoByName(String name) {
        return platoList.stream()
                .filter(plato -> plato.getNombre().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public List<Ingrediente> findAll() {
        return ingredienteList;
    }

    @Override
    public List<Plato> findAllPlatos() {
        return this.platoList;
    }

    private List<Ingrediente> leerJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/food.json"));
        return om.readValue(reader, new TypeReference<>() {
        });
    }

    private void cargarPlatos() {
        platoList.add(new Plato("Plato1", ingredienteList.subList(4,8)));
        platoList.add(new Plato("Plato2", ingredienteList.subList(7,16)));
        platoList.add(new Plato("Plato3", ingredienteList.subList(23,25)));
        platoList.add(new Plato("Plato4", ingredienteList.subList(17,20)));
        platoList.add(new Plato("Plato5", ingredienteList.subList(30,34)));
        platoList.add(new Plato("Plato6", ingredienteList.subList(27,30)));
    }
}
