package com.ospina.calculadoraCalorias.servicio;

import com.ospina.calculadoraCalorias.excepcion.PlatoNoEncontradoExcepcion;
import com.ospina.calculadoraCalorias.modelo.dto.PlatoDTO;
import com.ospina.calculadoraCalorias.modelo.request.RequestPlato;

public interface ServicioComida {

    PlatoDTO obtenerDatos(RequestPlato requestPlato) throws PlatoNoEncontradoExcepcion;
}
