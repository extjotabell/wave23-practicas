package com.example.InsuranceCompany.service;

import com.example.InsuranceCompany.dto.*;

import java.util.List;

public interface IVehicleService {

    List<VehicleDTO> getVehicles();
    VehicleDTO getVehicleById(Long id);
    MessageDTO addvehicle(VehicleDTO vehicle);
    VehicleDTO updateVehicle(Long id, VehicleDTO vehicle);
    MessageDTO deleteVehicle(Long id);
    List<VehiclePatentDTO> getAllPatents();
    List<VehiclePatentBrandDTO> getPatentAndBrandByYearOfManufacture();
    List<VehiclePatentDTO> getPatentByFourWheelsAndManufactureCurrentYear();
    List<VehiclePatentBrandModelDTO> getPatentBrandModelByAccidentWithLossGreaterThan10000();
    List<VehiclePatentBrandLossDTO> getVehicleDetailsWithTotalLossGreaterThan10000();
}
