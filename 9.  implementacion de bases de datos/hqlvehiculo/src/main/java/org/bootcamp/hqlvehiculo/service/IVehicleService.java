package org.bootcamp.hqlvehiculo.service;

import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelTotalCostDTO;

import java.util.List;

public interface IVehicleService {

    List<String> getLicencePlates();

    List<VehicleLicenceBrandDTO> getLicenceBrandByYear(Integer year);

    List<String> getLicencePlateMoreThanFourWheelsFromCurrentYear();

    List<VehicleLicenceBrandModelDTO> getLicenceBrandModelFromAccidentsMoreThan10000Costs();

    List<VehicleLicenceBrandModelTotalCostDTO> getLicenceBrandModelFromAccidensMoreThan10000CostsWithTotalCost();

}
