package com.pereiravilches.Concesionaria.service;

import com.pereiravilches.Concesionaria.DTO.RequestVehiculoDTO;
import com.pereiravilches.Concesionaria.DTO.ResponseDTO;
import com.pereiravilches.Concesionaria.entity.Vehiculo;
import com.pereiravilches.Concesionaria.exception.ErrorAlAgregarVehiculoException;
import com.pereiravilches.Concesionaria.exception.ErrorSolicitudException;
import com.pereiravilches.Concesionaria.exception.VehiculoNoEncontradoException;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionariaService {

    ResponseDTO agregarVehiculo(RequestVehiculoDTO requestVehiculoDTO) throws ErrorAlAgregarVehiculoException;

    RequestVehiculoDTO getVehiculoById(Integer id) throws VehiculoNoEncontradoException;

    List<RequestVehiculoDTO> getUsados() throws ErrorSolicitudException;
    List<RequestVehiculoDTO> getVehiculosPorFechaDeFabricación(LocalDate since, LocalDate to) throws ErrorSolicitudException;
    List<RequestVehiculoDTO> getVehiculosPorPrecio(Integer since, Integer to) throws ErrorSolicitudException;
}
