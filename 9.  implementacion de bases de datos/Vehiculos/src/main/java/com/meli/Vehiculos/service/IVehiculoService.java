package com.meli.Vehiculos.service;

import com.meli.Vehiculos.dto.request.VehiculoRequestDTO;
import com.meli.Vehiculos.dto.response.VehiculoResponseDTO;

import java.util.List;

public interface IVehiculoService {

    List<VehiculoResponseDTO> findAll();
    VehiculoResponseDTO findById(Long id);
    VehiculoResponseDTO save(VehiculoRequestDTO vehiculoDTO);

    List<String> findAllPatentes();
    List<VehiculoResponseDTO> findAllPatentesAndMarcaOrderByYearFabricacion();
    List<String> findAllPatentesByCantidadRuedasAndYearFabricacion(Integer cantidadRuedas, Integer yearFabricacion);
    List<VehiculoResponseDTO> findAllByPerdidaEconomicaSiniestroIsGreaterOrEqualThan(Double perdidaEconomicaSiniestro);
    List<VehiculoResponseDTO> findVehiclesWithTotalLossGreaterThan(Double perdidaEconomicaSiniestro);


}
