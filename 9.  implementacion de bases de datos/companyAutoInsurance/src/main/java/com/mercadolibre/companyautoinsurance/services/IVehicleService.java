package com.mercadolibre.companyautoinsurance.services;

import com.mercadolibre.companyautoinsurance.models.dtos.VehicleDTO;
import com.mercadolibre.companyautoinsurance.models.dtos.VehicleWithTotalLossDTO;

import java.util.List;

public interface IVehicleService {
    VehicleDTO saveVehicle(VehicleDTO vehicleDTO);

    List<String> findAllRegisteredVehiclesPatents();

    List<VehicleDTO> findAllPatentAndBrandVehiclesOrderByYearFabrication();

    List<String> findAllPatentVehiclesWithMoreThanFourWheelsAndManufacturedThisYear();

    List<VehicleDTO> findAllPatentBrandAndModelVehiclesWithAccidentsWithLossGreaterThan10000();

    VehicleWithTotalLossDTO findPatentBrandAndModelVehiclesWithAccidentsWithLossGreaterThan10000AndTotalLoss();
}
