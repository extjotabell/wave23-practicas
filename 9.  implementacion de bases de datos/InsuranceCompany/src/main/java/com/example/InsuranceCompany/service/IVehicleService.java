package com.example.InsuranceCompany.service;

import com.example.InsuranceCompany.dto.MessageDTO;
import com.example.InsuranceCompany.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {

    List<VehicleDTO> getVehicles();
    VehicleDTO getVehicleById(Long id);
    MessageDTO addvehicle(VehicleDTO vehicle);
    VehicleDTO updateVehicle(Long id, VehicleDTO vehicle);
    MessageDTO deleteVehicle(Long id);
}
