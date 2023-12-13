package com.example.ejercicio_covid.repository;

import com.example.ejercicio_covid.entitie.Persona;
import com.example.ejercicio_covid.entitie.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class PersonaRepositoryImpl implements IPersonaRepository{
    SintomaRepositoryImpl repository = new SintomaRepositoryImpl();

    private List<Sintoma> sintomas = repository.findAll();

    private List<Persona> data = new ArrayList<>();
    @Override
    public List<Persona> findAll() {
        return data;
    }

    PersonaRepositoryImpl(){
        loadData();
    }

    public void loadData(){
        data.add(new Persona(1,"Martin","Lackington",26,sintomas.get(0)));
        data.add(new Persona(2,"Carlos","Lopez",30,sintomas.get(1)));
        data.add(new Persona(3,"Elisa","Perez",80,sintomas.get(2)));
        data.add(new Persona(4,"Arturo","Lagos",62,sintomas.get(0)));
    }
}
