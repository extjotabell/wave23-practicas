package org.bootcamp.hqlvehiculo.service;

import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelDTO;
import org.bootcamp.hqlvehiculo.model.dto.VehicleLicenceBrandModelTotalCostDTO;
import org.bootcamp.hqlvehiculo.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImplementation implements IVehicleService{

    @Autowired
    private IVehicleRepository repository;


    @Override
    @Transactional
    public List<String> getLicencePlates() {
        return repository.getLicencePlates();
    }

    @Override
    @Transactional
    public List<VehicleLicenceBrandDTO> getLicenceBrandByYear(Integer year) {
        return repository.getLicenceBrandByYear(year);
    }

    @Override
    @Transactional
    public List<String> getLicencePlateMoreThanFourWheelsFromCurrentYear() {
        return repository.getLicencePlateMoreThanFourWheelsFromCurrentYear();
    }

    @Override
    @Transactional
    public List<VehicleLicenceBrandModelDTO> getLicenceBrandModelFromAccidentsMoreThan10000Costs() {
        return repository.getLicenceBrandModelFromAccidentsMoreThan10000Costs();
    }

    @Override
    @Transactional
    public List<VehicleLicenceBrandModelTotalCostDTO> getLicenceBrandModelFromAccidensMoreThan10000CostsWithTotalCost() {
        return repository.getLicenceBrandModelFromAccidensMoreThan10000CostsWithTotalCost();
    }
}
