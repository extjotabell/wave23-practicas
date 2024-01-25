package com.example.covid.repository;

import com.example.covid.entity.Sintoma;

import java.util.List;

public interface ISintomaRepository {
    List<Sintoma> findAll();
}
