package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.AlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.VehicleMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void create(VehicleDto vehicleDto) {
        if (vehicleRepository.find(vehicleDto.getId()).isPresent())
            throw new AlreadyExistsException("Ya se encuentra un auto registrado con el ID dado.");
        vehicleRepository.create(VehicleMapper.mapToEntity(vehicleDto));
    }

    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year) {
        List<VehicleDto> vehicleDtos = vehicleRepository.findByColorAndYear(color, year)
                .stream().map(VehicleMapper::mapToDTO).toList();
        if (vehicleDtos.isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con los criterios dados.");
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> findByBrandAndYearRange(String brand, int startYear, int endYear) {
        List<VehicleDto> vehicleDtos = vehicleRepository.findByBrandAndYearRange(brand, startYear, endYear)
                .stream().map(VehicleMapper::mapToDTO).toList();
        if (vehicleDtos.isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con los criterios dados.");
        return vehicleDtos;
    }

    @Override
    public Double getAverageSpeedByBrand(String brand) {
        if (!vehicleRepository.anyMatchBrand(brand))
            throw new NotFoundException("No se encontro ningun auto en el sistema con la marca dada.");
        return vehicleRepository.getAverageSpeedByBrand(brand);
    }

    @Override
    public void createBatch(List<VehicleDto> vehicles) {
        vehicles.forEach(vehicleDto -> {
            if (vehicleRepository.find(vehicleDto.getId()).isPresent())
                throw new AlreadyExistsException(
                        "Ya se encuentra un auto registrado con el ID proporcionado: " + vehicleDto.getId());
        });
        vehicleRepository.createBatch(vehicles.stream().map(VehicleMapper::mapToEntity).toList());
    }

    @Override
    public void updateMaxSpeed(Long id, String maxSpeed) {
        if (vehicleRepository.find(id).isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con el ID dado.");
        vehicleRepository.updateMaxSpeed(id, maxSpeed);
    }

    @Override
    public List<VehicleDto> findByFuelType(String fuelType) {
        if (!vehicleRepository.anyMatchFuelType(fuelType))
            throw new NotFoundException("No se encontro ningun auto en el sistema con el tipo de combustible dado.");
        return vehicleRepository.findByFuelType(fuelType).stream().map(VehicleMapper::mapToDTO).toList();
    }

    @Override
    public void delete(Long id) {
        if (vehicleRepository.find(id).isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con el ID dado.");
        vehicleRepository.delete(id);
    }

    @Override
    public List<VehicleDto> findByTransmission(String transmission) {
        if (vehicleRepository.anyMatchTransmission(transmission))
            throw new NotFoundException("No se encontro ningun auto en el sistema con el tipo de transmision dada.");
        return vehicleRepository.findByTransmission(transmission).stream().map(VehicleMapper::mapToDTO).toList();
    }

    @Override
    public void updateFuelType(Long id, String fuelType) {
        if (vehicleRepository.find(id).isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con el ID dado.");
        vehicleRepository.updateFuelType(id, fuelType);
    }

    @Override
    public Double getAverageCapacityByBrand(String brand) {
        if (!vehicleRepository.anyMatchBrand(brand))
            throw new NotFoundException("No se encontro ningun auto en el sistema con la marca dada.");
        return vehicleRepository.getAverageCapacityByBrand(brand);
    }

    @Override
    public List<VehicleDto> findByDimensions(String heightRange, String widthRange) {
        double minHeight = Double.parseDouble(heightRange.split("-")[0]);
        double maxHeight = Double.parseDouble(heightRange.split("-")[1]);

        double minWidth = Double.parseDouble(widthRange.split("-")[0]);
        double maxWidth = Double.parseDouble(widthRange.split("-")[1]);

        List<VehicleDto> vehicleDtos = vehicleRepository.findByDimensions(minHeight, maxHeight, minWidth, maxWidth)
                .stream().map(VehicleMapper::mapToDTO).toList();

        if (vehicleDtos.isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con los criterios dados.");
        return vehicleDtos;
    }

    @Override
    public List<VehicleDto> findByWeightRange(double minWeight, double maxWeight) {
        List<VehicleDto> vehicleDtos = vehicleRepository.findByWeightRange(minWeight, maxWeight)
                .stream().map(VehicleMapper::mapToDTO).toList();

        if (vehicleDtos.isEmpty())
            throw new NotFoundException("No se encontro ningun auto en el sistema con los criterios dados.");
        return vehicleDtos;
    }
}
