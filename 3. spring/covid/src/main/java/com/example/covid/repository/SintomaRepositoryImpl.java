package com.example.covid.repository;

import com.example.covid.entity.Sintoma;
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
        data.add(new Sintoma(1,"Dolor de panza","Leve"));
        data.add(new Sintoma(2,"Dificultad Respiratoria","Grave"));
        data.add(new Sintoma(2,"Dolor de cabeza","Grave"));
        data.add(new Sintoma(3,"Mareo","Normal"));
    }

}
