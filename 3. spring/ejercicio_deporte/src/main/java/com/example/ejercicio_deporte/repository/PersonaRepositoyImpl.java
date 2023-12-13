package com.example.ejercicio_deporte.repository;

import com.example.ejercicio_deporte.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepositoyImpl implements IPersonaRepository{

    private List<Persona> data = new ArrayList<>();

    PersonaRepositoyImpl(){
        loadData();
    }

    public void loadData(){
        data.add(new Persona("Martin","Lackington",26));
        data.add(new Persona("Carlos","Lopez",45));
        data.add(new Persona("Elisa","Perez",70));
    }
    @Override
    public List<Persona> findAll() {
        return data;
    }
}
