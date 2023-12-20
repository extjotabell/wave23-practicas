package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.DuplicateIDException;
import com.bootcampW22.EjercicioGlobal.exception.InvalidInputException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
        this.mapper = new ObjectMapper();
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto save(VehicleDto vehicleDto) {
        try{
            if ( vehicleRepository.findAll().stream().map(v -> v.getId()).toList().contains( vehicleDto.getId()))
                throw new DuplicateIDException("El id ingresado ya se encuentra registrado");

            Vehicle vehicle = mapper.convertValue(vehicleDto, Vehicle.class);
            vehicleRepository.save(vehicle);
        }catch (Exception e){
            throw  new InvalidInputException("El vehiculo ingresado no cuenta con los campos requeridos");
        }
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> filterByColorAndYear(String color, int year) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                                                            .filter(v -> v.getColor().equals(color) && v.getYear() == year)
                                                            .toList();
        if (vehicles.isEmpty()) throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        return vehicles.stream().map( v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public List<VehicleDto> filterByBrandAndRangeDate(String brand, int startYear, int endYear) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                                                            .filter(v -> v.getYear() >= startYear &&
                                                                         v.getYear() <= endYear  &&
                                                                         v.getBrand().equals(brand))
                                                            .toList();
        if (vehicles.isEmpty()) throw new NotFoundException("No se encontraron vehículos con esos criterios.");

        return vehicles.stream().map( v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public Double getAverageSpeedByBrand(String brand) {
        OptionalDouble average = vehicleRepository.findAll().stream()
                .filter(v -> v.getBrand().equals(brand))
                .mapToDouble(v -> Double.parseDouble(v.getMax_speed())).average();

        if (average.isPresent())  return average.getAsDouble();

        throw new NotFoundException("No se encontraron vehículos de esa marca");
    }

    @Override
    public List<VehicleDto> save(List<VehicleDto> vehiclesDto) {
        List<Long> ids = vehicleRepository.findAll().stream().map(v -> v.getId()).toList();

        List<VehicleDto> idsDTOs = vehiclesDto.stream().filter(v -> ids.contains(v.getId())).toList();
        if  (!idsDTOs.isEmpty()) throw  new DuplicateIDException( "Algún vehículo tiene un identificador ya existente.");
        try{
            vehiclesDto.stream()
                    .map(v -> mapper.convertValue(v, Vehicle.class))
                    .forEach(v -> vehicleRepository.save(v));

        }catch (Exception e){
            throw  new InvalidInputException("Datos de algún vehículo mal formados o incompletos.");
        }
        return vehiclesDto;
    }

    @Override
    public VehicleDto updateSpeed(Long id, String newSpeed) {
        Optional<Vehicle> vehicle = vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getId().equals(id)).findFirst();
        if (vehicle.isEmpty()) throw  new NotFoundException("No se encontró el vehículo.");

        if (Integer.valueOf(newSpeed) < 0 || Integer.valueOf(newSpeed) > 200)
            throw new InvalidInputException("Velocidad mal formada o fuera de rango");

        vehicle.get().setMax_speed(newSpeed);
        int indice = vehicleRepository.findAll().indexOf(vehicle.get());
        vehicleRepository.findAll().set(indice, vehicle.get());
        return mapper.convertValue(vehicle.get(), VehicleDto.class);
    }

    @Override
    public List<VehicleDto> filterByFuelType(String fuelType) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                                                            .filter( v -> v.getFuel_type().equals(fuelType))
                                                            .toList();
        if (vehicles.isEmpty()) throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible");

        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public void delete(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findAll().stream().filter( v -> v.getId().equals(id)).findFirst();
        if (vehicle.isEmpty()) throw new NotFoundException("No se encontró el vehículo.");

        vehicleRepository.delete(vehicle.get());
    }

    @Override
    public List<VehicleDto> filterByTransmission(String type) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                                                            .filter(v -> v.getTransmission().equals(type))
                                                            .toList();
        if (vehicles.isEmpty()) throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");

        return vehicles.stream().map( v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }

    @Override
    public VehicleDto updateFuel(Long id, String fuel) {
        Optional<Vehicle> vehicle = vehicleRepository.findAll().stream().filter(v -> v.getId().equals(id)).findFirst();
        if (vehicle.isEmpty()) throw  new NotFoundException("No se encontró el vehículo.");

        List<String> fuels = List.of("biodiesel", "gas", "diesel", "gasoline");

        if (!fuels.contains(fuel)) throw new InvalidInputException("Tipo de combustible mal formado o no admitido.");

        int index = vehicleRepository.findAll().indexOf(vehicle.get());
        vehicle.get().setFuel_type(fuel);
        vehicleRepository.findAll().set(index, vehicle.get());
        return mapper.convertValue(vehicle.get(), VehicleDto.class);
    }

    @Override
    public Double getAverageCapacity(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findAll().stream()
                                                            .filter( v -> v.getBrand().equals(brand))
                                                            .toList();
        if (vehicles.isEmpty()) throw new NotFoundException("No se encontraron vehículos de esa marca.");

        double result = vehicles.stream().mapToInt(Vehicle::getPassengers)
                .average().getAsDouble();

        return result;
    }

    private boolean validateWellFormed(VehicleDto v){
        return true;
    }
}
