package com.pereiravilches.Concesionaria.service;

import com.pereiravilches.Concesionaria.DTO.RequestVehiculoDTO;
import com.pereiravilches.Concesionaria.DTO.ResponseDTO;
import com.pereiravilches.Concesionaria.entity.Vehiculo;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaService {

    ResponseDTO agregarVehiculo(RequestVehiculoDTO requestVehiculoDTO);

    RequestVehiculoDTO getVehiculoById(Integer id);

    List<RequestVehiculoDTO> getUsados();
    List<RequestVehiculoDTO> getVehiculosPorFechaDeFabricación(LocalDate since, LocalDate to);
    List<RequestVehiculoDTO> getVehiculosPorPrecio(Integer since, Integer to);
}
