package com.mercadolibre.companyautoinsurance.utils;

import com.mercadolibre.companyautoinsurance.models.dtos.AccidentDTO;
import com.mercadolibre.companyautoinsurance.models.dtos.VehicleDTO;
import com.mercadolibre.companyautoinsurance.models.entities.Accident;
import com.mercadolibre.companyautoinsurance.models.entities.Vehicle;

public class Mapper {

    private Mapper() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static VehicleDTO mapToVehicleDTO(Vehicle vehicle) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setPatentVehicles(vehicle.getPatentVehicles());
        vehicleDTO.setBrandVehicles(vehicle.getBrandVehicles());
        vehicleDTO.setModelVehicles(vehicle.getModelVehicles());
        vehicleDTO.setYearBuildVehicles(vehicle.getYearBuildVehicles());
        vehicleDTO.setQuantityWheelsVehicles(vehicle.getQuantityWheelsVehicles());
        return vehicleDTO;
    }

    public static Vehicle mapToVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setPatentVehicles(vehicleDTO.getPatentVehicles());
        vehicle.setBrandVehicles(vehicleDTO.getBrandVehicles());
        vehicle.setModelVehicles(vehicleDTO.getModelVehicles());
        vehicle.setYearBuildVehicles(vehicleDTO.getYearBuildVehicles());
        vehicle.setQuantityWheelsVehicles(vehicleDTO.getQuantityWheelsVehicles());
        return vehicle;
    }

    public static VehicleDTO mapToVehicleDTOWithPatentAndBrand(Object[] patentAndBrand) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setPatentVehicles((String) patentAndBrand[0]);
        vehicleDTO.setBrandVehicles((String) patentAndBrand[1]);
        return vehicleDTO;
    }

    public static VehicleDTO mapToVehicleDTOWithPatentBrandAndModel(Object[] patentBrandAndModel) {
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setPatentVehicles((String) patentBrandAndModel[0]);
        vehicleDTO.setBrandVehicles((String) patentBrandAndModel[1]);
        vehicleDTO.setModelVehicles((String) patentBrandAndModel[2]);
        return vehicleDTO;
    }

    public static VehicleDTO mapToVehicleDTOAndLoss(Object[] vehicleData) {
        Vehicle vehicle = (Vehicle) vehicleData[0];
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setPatentVehicles(vehicle.getPatentVehicles());
        vehicleDTO.setBrandVehicles(vehicle.getBrandVehicles());
        vehicleDTO.setModelVehicles(vehicle.getModelVehicles());
        return vehicleDTO;
    }

    public static AccidentDTO mapToAccidentDTO(Accident accident) {
        AccidentDTO accidentDTO = new AccidentDTO();
        accidentDTO.setId(accident.getId());
        accidentDTO.setAccidentDate(accident.getAccidentDate());
        accidentDTO.setEconomicLoss(accident.getEconomicLoss());
        accidentDTO.setVehicleId(accident.getVehicle().getId());
        return accidentDTO;
    }

    public static Accident mapToAccident(AccidentDTO accidentDto) {
        Accident accident = new Accident();
        accident.setId(accidentDto.getId());
        accident.setEconomicLoss(accidentDto.getEconomicLoss());
        accident.setAccidentDate(accidentDto.getAccidentDate());
        Vehicle vehicle = new Vehicle();
        vehicle.setId(accidentDto.getVehicleId());
        accident.setVehicle(vehicle);
        return accident;
    }
}