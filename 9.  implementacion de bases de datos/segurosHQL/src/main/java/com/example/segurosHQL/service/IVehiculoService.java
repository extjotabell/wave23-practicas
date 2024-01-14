package com.example.segurosHQL.service;

import com.example.segurosHQL.model.dto.VehiculoDTO;

import java.util.List;

public interface IVehiculoService {
    List<VehiculoDTO>getVehiculos();
    List<VehiculoDTO>getPatentes();
    List<VehiculoDTO>getPatentesByAnio();
    List<VehiculoDTO>patentesAnioRuedas();
}
