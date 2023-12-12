package com.calculadoraCalorias.calculadoraCalorias.repository;
import com.calculadoraCalorias.calculadoraCalorias.entity.Ingrediente;
import com.calculadoraCalorias.calculadoraCalorias.entity.Plato;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngedienteRepository implements IIngredienteRepository{

    List<Ingrediente> ingredientes;
    List<Plato> platos;

    public IngedienteRepository(){
        cargarJson();
    }

    private void cargarJson(){
        ingredientes = new ArrayList<>();
        platos = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/cvargassilva/Downloads/calculadoraCalorias/src/main/resources/food.json"));
            ObjectMapper objectMapper = new ObjectMapper();

            List<Ingrediente> listFromJson = objectMapper.readValue(reader,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Ingrediente.class));

            listFromJson.stream().forEach(c -> ingredientes.add(c));

            cargarPlatos();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarPlatos(){
        List<Ingrediente> ingredientesplato1 = List.of(ingredientes.get(0),ingredientes.get(1), ingredientes.get(4), ingredientes.get(13));
        Plato plato1 = Plato.builder().name("Ensalada").ingredients(ingredientesplato1).build();

        List<Ingrediente> ingredientesplato2 = List.of(ingredientes.get(27));
        Plato plato2 = Plato.builder().name("Papas Fritas").ingredients(ingredientesplato2).build();

        List<Ingrediente> ingredientesplato3 = List.of(ingredientes.get(4),ingredientes.get(54), ingredientes.get(12));
        Plato plato3 = Plato.builder().name("Sopa").ingredients(ingredientesplato3).build();

        platos.addAll(List.of(plato1, plato2, plato3));

    }

    @Override
    public List<Ingrediente> getAllIngredientes() {
        return ingredientes;
    }

    @Override
    public List<Plato> getAllPlatos() {
        return platos;
    }
}
