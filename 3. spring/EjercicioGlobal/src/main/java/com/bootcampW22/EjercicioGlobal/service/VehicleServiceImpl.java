package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
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
    public VehicleDto saveVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = mapper.convertValue(vehicleDto,Vehicle.class);
        if(!validarId(vehicle.getId())){
            Vehicle result = vehicleRepository.saveVehicle(Objects.requireNonNull(vehicle));
            return mapper.convertValue(result,VehicleDto.class);
        } else{
            throw new ConflictException("El vehiculo ya existe");
        }
    }

    @Override
    public List<VehicleDto> getAllByColorAndYear(String color, int year) {
        List<Vehicle> vehicleList = vehicleRepository.getAllByColorAndYear(color,year);
        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos de color "+color+" y año "+year);
        }

        vehicleList.stream().forEach(vehicle -> {
            vehicleDtoList.add(mapper.convertValue(vehicle,VehicleDto.class));
        });

        return vehicleDtoList;
    }

    @Override
    public List<VehicleDto> getAllByBrandAndYear(String brand, int start_year, int end_year) {
        List<Vehicle> vehicleList = vehicleRepository.getAllByBrandAndYear(brand,start_year,end_year);
        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        if(vehicleDtoList.isEmpty()){
            throw new NotFoundException("No hay vehiculos para la marca "+brand+" y las fechas indicadas: desde"+start_year+" hasta "+end_year);
        }

        vehicleList.stream().forEach(vehicle -> {
            vehicleDtoList.add(mapper.convertValue(vehicle,VehicleDto.class));
        });
        return vehicleDtoList;
    }

    @Override
    public double getMaxSpeedAverageByBrand(String brand) {
        if(vehicleRepository.findByBrand(brand)==null){
            throw new NotFoundException("No hay vehiculos para la marca "+brand);
        }
        double speedAVG = vehicleRepository.getMaxSpeedAverageByBrand(brand);
        return speedAVG;
    }

    @Override
    public Boolean validarId(long id) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.stream().anyMatch(vehicle -> vehicle.getId() == id)){
            return true;
        }
        return false;
    }

    @Override
    public VehicleDto updateSpeed(long id, double speed) {
        Vehicle vehicle = vehicleRepository.updateSpeed(id,speed);
        return mapper.convertValue(vehicle,VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getAllByFuelType(String type) {
        List<Vehicle> vehicleList = vehicleRepository.getAllByFuelType(type);
        List<VehicleDto>vehicleDtoList=new ArrayList<>();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con combustible del tipo: "+type);
        }

        vehicleList.stream().forEach(vehicle -> {
            vehicleDtoList.add(mapper.convertValue(vehicle,VehicleDto.class));
        });

        return vehicleDtoList;
    }

    @Override
    public Boolean delete(long id) {
        if(id <= 0){
            throw new BadRequestException("Error de dato o valor no admitido");
        }

        Boolean response = vehicleRepository.delete(id);

        if(!response){
            throw new NotFoundException("No se encontro el vehiculo");
        }

        return response;
    }

    @Override
    public int getCapacityByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.findByBrand(brand);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No hay vehiculos para la marca "+brand);
        }

        return vehicleRepository.getCapacityByBrand(brand);
    }

    @Override
    public List<VehicleDto> getByDimensions(double length, double width) {
        List<Vehicle> vehicleList = vehicleRepository.getByDimensions(length,width);
        List<VehicleDto>vehicleDtoList=new ArrayList<>();

        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones: "+length+", "+width);
        }

        vehicleList.stream().forEach(vehicle -> {
            vehicleDtoList.add(mapper.convertValue(vehicle,VehicleDto.class));
        });

        return vehicleDtoList;
    }

    @Override
    public List<VehicleDto> getByTransmission(String type) {
        List<Vehicle> vehicleList = vehicleRepository.getByTransmission(type);
        List<VehicleDto> vehicleDto = new ArrayList<>();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehiculos con ese tipo de transmision: "+type);
        }
        vehicleList.stream().forEach(vehicle -> {
            vehicleDto.add(mapper.convertValue(vehicle,VehicleDto.class));
        });
        return vehicleDto;
    }

    @Override
    public VehicleDto updateFuel(long id, String fuel) {
        if(fuel.equals("gas") ||fuel.equals("gasoline") || fuel.equals("biodiesel")){
            throw new BadRequestException("Tipo de combustible mal formado o no admitido.");
        }

        Vehicle vehicle = vehicleRepository.updateFuel(id,fuel);

        if(vehicle == null){
            throw new NotFoundException("No se encontró el vehículo.");
        }

        VehicleDto vehicleDto = mapper.convertValue(vehicle, VehicleDto.class);
        return vehicleDto;
    }

    @Override
    public List<VehicleDto> getAllByWeight(double weight_min, double weight_max) {
        List<Vehicle> vehicleList = vehicleRepository.getAllByWeight(weight_min,weight_max);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }
        List<VehicleDto> vehicleDtoList = new ArrayList<>();
        vehicleList.stream().forEach(vehicle -> {
                vehicleDtoList.add(mapper.convertValue(vehicle,VehicleDto.class));
        });
        return vehicleDtoList;
    }

    @Override
    public List<VehicleDto> saveAll(List<VehicleDto> vehicleDtoList) {
        List<Vehicle> vehicleList = new ArrayList<>();
        if(vehicleDtoList.stream().anyMatch(vehicleDto -> vehicleDto==null)){
            throw new BadRequestException("Datos de algún vehículo mal formados o incompletos.");
        }

        for (VehicleDto v : vehicleDtoList){
            if(validarId(v.getId())){
                throw new ConflictException("Vehiculo ya existe id:"+v.getId());
            }
        }

        vehicleDtoList.stream().forEach(vehicle -> {
            vehicleList.add(mapper.convertValue(vehicle, Vehicle.class));
        });

        List<Vehicle> response = vehicleRepository.saveAll(vehicleList);

        List<VehicleDto> responseDto = new ArrayList<>();

        response.stream().forEach(vehicle -> {
            responseDto.add(mapper.convertValue(vehicle, VehicleDto.class));
        });

        return responseDto;
    }
}
