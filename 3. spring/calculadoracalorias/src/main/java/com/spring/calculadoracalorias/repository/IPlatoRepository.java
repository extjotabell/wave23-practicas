package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.entity.Plato;

public interface IPlatoRepository {

    Plato getPlatos(String nombre);
}
