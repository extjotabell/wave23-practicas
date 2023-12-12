package com.example.calculadoraCalorias.repository;

import com.example.calculadoraCalorias.entity.Ingrediente;
import com.example.calculadoraCalorias.entity.IngredientesCantidad;
import com.example.calculadoraCalorias.entity.Plato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;


@Repository
public class CaloriasRepository implements ICaloriasRepository{

    List<Ingrediente> data = new ArrayList<>();
    List<Plato> dataPlatos = new ArrayList<>();

    public CaloriasRepository(){
        loadIngredientsFromJson();
        loadPlatos();
    }
    private void loadIngredientsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("food.json").getFile();

            Ingrediente[] characterArray = objectMapper.readValue(file, Ingrediente[].class);
            data = Arrays.asList(characterArray);
        } catch (IOException e) {
            e.printStackTrace();
            /*throw new JsonReadException("Error al leer el archivo JSON");*/
        }
    }

    private void loadPlatos(){
       dataPlatos.add(new Plato("Pizza", List.of(
               new IngredientesCantidad("Aceitunas verdes", 1)
               ,new IngredientesCantidad("Harina de trigo refinada",1))));
    }

    @Override
    public List<Ingrediente> getAll() {
        return data;
    }

    @Override
    public List<Plato> getPlatos() {
        return dataPlatos;
    }

    @Override
    public Ingrediente getIngrediente(String nombre) {
        Optional<Ingrediente> ing = data.stream().filter(i -> i.getName().equals(nombre)).findFirst();
        return ing.orElse(null);
    }

}
