package com.ospina.calculadoraCalorias.servicio;

import com.ospina.calculadoraCalorias.excepcion.PlatoNoEncontradoExcepcion;
import com.ospina.calculadoraCalorias.modelo.dto.PlatoDTO;
import com.ospina.calculadoraCalorias.modelo.request.RequestPlato;

import java.util.List;

public interface ServicioComida {

    PlatoDTO obtenerDatos(RequestPlato requestPlato) throws PlatoNoEncontradoExcepcion;

    List<PlatoDTO> obtenerDatosVarios(List<RequestPlato> requestPlatos) throws PlatoNoEncontradoExcepcion;
}
