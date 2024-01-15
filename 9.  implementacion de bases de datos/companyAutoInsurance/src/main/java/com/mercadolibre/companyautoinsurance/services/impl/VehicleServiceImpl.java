package com.mercadolibre.companyautoinsurance.services.impl;

import com.mercadolibre.companyautoinsurance.models.dtos.VehicleDTO;
import com.mercadolibre.companyautoinsurance.models.dtos.VehicleWithTotalLossDTO;
import com.mercadolibre.companyautoinsurance.models.entities.Vehicle;
import com.mercadolibre.companyautoinsurance.repositories.IVehicleRepository;
import com.mercadolibre.companyautoinsurance.services.IVehicleService;
import com.mercadolibre.companyautoinsurance.utils.Mapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(IVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;

    }

    /**
     * Save a new vehicle
     */
    @Override
    @Transactional
    public VehicleDTO saveVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = Mapper.mapToVehicle(vehicleDTO);
        vehicle = vehicleRepository.save(vehicle);
        return Mapper.mapToVehicleDTO(vehicle);
    }

    /**
     * List all the patents of the vehicles registered
     */
    @Override
    @Transactional
    public List<String> findAllRegisteredVehiclesPatents() {
        return vehicleRepository.findAllRegisteredVehiclesPatents();
    }

    /**
     * List all the patents and brands of the vehicles registered and order by year of fabrication
     */
    @Override
    @Transactional
    public List<VehicleDTO> findAllPatentAndBrandVehiclesOrderByYearFabrication() {
        return vehicleRepository.findAllPatentAndBrandVehiclesOrderByYearFabrication()
                .stream()
                .map(Mapper::mapToVehicleDTOWithPatentAndBrand)
                .toList();
    }

    /**
     * List all the patents and brands of the vehicles manufactured the current year
     */
    @Override
    @Transactional
    public List<String> findAllPatentVehiclesWithMoreThanFourWheelsAndManufacturedThisYear() {
        return vehicleRepository.findAllVehiclesWithMoreThanFourWheelsAndManufacturedThisYear();
    }

    /**
     * List all the patents, brand and model of all vehicles with an accident with loss greater than 10000
     */
    @Override
    @Transactional
    public List<VehicleDTO> findAllPatentBrandAndModelVehiclesWithAccidentsWithLossGreaterThan10000() {
        return vehicleRepository.findAllVehiclesWithAccidentsWithLossGreaterThan10000()
                .stream()
                .map(Mapper::mapToVehicleDTOWithPatentBrandAndModel)
                .toList();
    }

    /**
     * List all the patents, brand and model of all vehicles with an accident with loss greater than 10000 and show
     * the total loss
     */
    @Override
    @Transactional
    public VehicleWithTotalLossDTO findPatentBrandAndModelVehiclesWithAccidentsWithLossGreaterThan10000AndTotalLoss() {
        List<Object[]> results = vehicleRepository.findAllVehiclesWithAccidentsWithLossGreaterThan10000AndTotalLoss();
        List<VehicleDTO> vehicles = results.stream()
                .map(Mapper::mapToVehicleDTOAndLoss)
                .toList();
        Double totalLoss = results.stream()
                .mapToDouble(result -> (Double) result[1])
                .sum();
        VehicleWithTotalLossDTO response = new VehicleWithTotalLossDTO();
        response.setVehicles(vehicles);
        response.setTotalLoss(totalLoss);
        return response;
    }
}
