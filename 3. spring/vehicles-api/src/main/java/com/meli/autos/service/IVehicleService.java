package com.meli.autos.service;

import com.meli.autos.dto.request.VehicleEntryDTO;
import com.meli.autos.dto.response.VehicleDTO;

import java.util.List;

public interface IVehicleService {

    List<VehicleDTO> getAll();

    VehicleDTO addVehicle(VehicleEntryDTO vehicleDTO);

    VehicleDTO getById(long id);

    List<VehicleDTO> getAllByDateRange(String since, String to);

    List<VehicleDTO> getAllByPriceRange(String since, String to);
}
