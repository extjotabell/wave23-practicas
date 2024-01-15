package com.ospina.seguros.servicio;

import com.ospina.seguros.modelo.dto.VehiculoResponseMatriculaMarcaModeloDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePatenteMarcaDto;
import com.ospina.seguros.modelo.dto.VehiculoResponsePerdidaTotalDto;

import java.util.List;

public interface VehiculoServicio {

    List<String> listarPatentes();

    List<VehiculoResponsePatenteMarcaDto> listarPatentesYMarcasPorAnioDeFabricacion(Integer anioFabricacion);

    List<String> listarPatentesVehiculosConMasDeCuatroRuedasFabricadosEsteAnio();

    List<VehiculoResponseMatriculaMarcaModeloDto> listarMatriculaMarcaModeloPorPerdidaMayor10000();

    List<VehiculoResponsePerdidaTotalDto> listarVehiculosPorMatriculaMarcaModeloYTotalPerdida();
}
