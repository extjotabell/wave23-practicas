package com.ospina.deportistas.servicio;

import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.excepcion.DeporteNoEncontradoExcepcion;

import java.util.List;

public interface DeporteServicio {
    List<Deporte> obtenerTodos();
    Deporte obtenerPorNombre(String nombre) throws DeporteNoEncontradoExcepcion;
}
