package com.ospina.calculadoraCalorias.repositorio.comida;

import com.ospina.calculadoraCalorias.modelo.entidad.Ingrediente;

import java.io.FileNotFoundException;
import java.util.List;

public interface RepositorioComida {

    List<Ingrediente> obtenerTodos();
}
