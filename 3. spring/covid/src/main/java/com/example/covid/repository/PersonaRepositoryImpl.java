package com.example.covid.repository;

import com.example.covid.entity.Persona;
import com.example.covid.entity.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
        data.add(new Persona(1,"Gabriel","Gutierrez",24,sintomas.get(1)));
        data.add(new Persona(2,"Mario","Besednjak",22,sintomas.get(0)));
        data.add(new Persona(3,"Elisa","Trotta",56,sintomas.get(1)));
        data.add(new Persona(4,"Felipe","Acosta",70,sintomas.get(2)));
    }
}
