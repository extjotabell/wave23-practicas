package com.meli.concesionaria.service;

import com.meli.concesionaria.dto.VehicleDto;

import java.time.LocalDate;
import java.util.List;

public interface IConcesionarioService {
    VehicleDto create(VehicleDto vehicle);

    List<VehicleDto> getAll();

    VehicleDto getById(Integer id);

    List<VehicleDto> getByDate(LocalDate since, LocalDate to);

    List<VehicleDto> getByPrice(Double since, Double to);
}
