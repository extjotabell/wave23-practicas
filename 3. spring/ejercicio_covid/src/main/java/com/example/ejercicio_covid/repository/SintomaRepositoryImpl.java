package com.example.ejercicio_covid.repository;

import com.example.ejercicio_covid.entitie.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class SintomaRepositoryImpl implements ISintomaRepository {

    private List<Sintoma> data = new ArrayList<>();
    @Override
    public List<Sintoma> findAll() {
        return data;
    }

    SintomaRepositoryImpl(){
        loadData();
    }

    public void loadData(){
        data.add(new Sintoma(1,"Dolor de estomago","Leve"));
        data.add(new Sintoma(2,"Dolor de cabeza","Grave"));
        data.add(new Sintoma(3,"Mareo","Normal"));
    }

}
