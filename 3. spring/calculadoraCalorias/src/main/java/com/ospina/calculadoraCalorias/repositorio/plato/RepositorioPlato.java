package com.ospina.calculadoraCalorias.repositorio.plato;

import com.ospina.calculadoraCalorias.modelo.entidad.Plato;

import java.util.List;

public interface RepositorioPlato{
    List<Plato> obtenerTodos();

    Plato obtenerPorNombre(String nombre);
}
