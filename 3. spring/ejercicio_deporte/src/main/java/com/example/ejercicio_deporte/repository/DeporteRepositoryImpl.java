package com.example.ejercicio_deporte.repository;

import com.example.ejercicio_deporte.entity.Deporte;
import com.example.ejercicio_deporte.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DeporteRepositoryImpl implements IDeporteRepository{

    PersonaRepositoyImpl repositoy = new PersonaRepositoyImpl();

    private List<Persona> personas = repositoy.findAll();
    private List<Deporte> data = new ArrayList<>();
    @Override
    public List<Deporte> findAll() {
        return data;
    }

    DeporteRepositoryImpl(){
        loadData();
    }

    public void loadData(){
        data.add(new Deporte("Soccer","Begginer", Arrays.asList(personas.get(0),personas.get(1))));
        data.add(new Deporte("Tennis","Amateur",Arrays.asList(personas.get(2))));
        data.add(new Deporte("Golf","Professional", Arrays.asList(personas.get(2),personas.get(1))));
    }
}
