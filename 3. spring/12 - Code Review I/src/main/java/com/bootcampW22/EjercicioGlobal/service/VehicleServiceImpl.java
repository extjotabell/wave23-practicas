package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.DatoStringDTO;
import com.bootcampW22.EjercicioGlobal.dto.DimensioneDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehiculoYaExisteException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.Parser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static com.bootcampW22.EjercicioGlobal.utils.Mapper.mapFromVehicleToVehicleDTO;
import static com.bootcampW22.EjercicioGlobal.utils.Mapper.mapVehiclesToVehiclesDto;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return mapVehiclesToVehiclesDto(vehicleList);
    }

    @Override
    public ResponseDTO addVehicle(VehicleDto vehicleDto) {
        Vehicle vehicle = mapFromVehicleToVehicleDTO(vehicleDto);
        if(vehicleRepository.findById(vehicle.getId()) != null){
            throw new VehiculoYaExisteException("Identificador del vehículo ya existente: " + vehicle.getId());
        }
        vehicleRepository.addVehicle(vehicle);
        return new ResponseDTO("El vehículo fue añadido exitosamente bajo el id: " + vehicle.getId());

    }

    @Override
    public List<VehicleDto> findByColorAndYear(String color, int year) {
        List<VehicleDto> encontrados = mapVehiclesToVehiclesDto(vehicleRepository.findByColorAndYear(color, year));
        if(encontrados.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return encontrados;
    }

    @Override
    public List<VehicleDto> findByBrandAndYears(String brand, int start_year, int end_year) {
        List<VehicleDto> encontrados = mapVehiclesToVehiclesDto(vehicleRepository.findByBrandAndYears(brand, start_year, end_year));
        if(encontrados.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return encontrados;
    }

    @Override
    public ResponseDTO getSpeedAverageByBrand(String brand) {
        OptionalDouble promedio = vehicleRepository.getSpeedAverageByBrand(brand);
        if(!promedio.isPresent()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        return new ResponseDTO("Velocidad promedio de la marca: " + brand + ": " + promedio);
    }

    @Override
    public List<ResponseDTO> addVehicles(List<VehicleDto> vehicles) {
        return vehicles.stream()
                 .map(this::addVehicle).toList();
    }

    @Override
    public ResponseDTO updateSpeed(Long id, DatoStringDTO updateSpeed) {
        if(vehicleRepository.findById(id) == null){
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicleRepository.updateSpeed(id,updateSpeed.getMessage());
        return new ResponseDTO("Velocidad actualizada a " + updateSpeed.getMessage() + ". Vehiculo:" + id);
    }

    @Override
    public List<VehicleDto> getVehiclesByDimensions(String lengthRange, String widthRange) {
        DimensioneDto dimensioneDto = Parser.getFilterFromStringToInt(lengthRange,widthRange);
        List<VehicleDto> encontrados = mapVehiclesToVehiclesDto(vehicleRepository.getVehiclesByDimensions(dimensioneDto.getMinLenght(), dimensioneDto.getMaxLenght(), dimensioneDto.getMinWidth(), dimensioneDto.getMaxWidth()));
        return encontrados;
    }

    @Override
    public ResponseDTO getCapacityAverageByBrand(String brand) {
        OptionalDouble promedio = vehicleRepository.getCapacityAverageByBrand(brand);
        if(!promedio.isPresent()){
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        return new ResponseDTO("Capacidad promedio de la marca: " + brand + ": " + promedio);
    }

    @Override
    public ResponseDTO updateFuel(Long id, DatoStringDTO updateFuel) {
        if(vehicleRepository.findById(id) == null){
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicleRepository.updateFuel(id,updateFuel.getMessage());
        return new ResponseDTO("Velocidad actualizada a " + updateFuel.getMessage() + ". Vehiculo:" + id);
    }

    @Override
    public List<VehicleDto> getVehiclesByWeight(double min, double max) {
        List<VehicleDto> encontrados = mapVehiclesToVehiclesDto(vehicleRepository.getVehiclesByWeight(min, max));
        if(encontrados.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return encontrados;
    }

    @Override
    public ResponseDTO deleteVehicle(Long id) {
        if(vehicleRepository.findById(id) == null){
            throw new NotFoundException("No se encontró el vehículo.");
        }
        vehicleRepository.deleteVehicle(id);
        return new ResponseDTO("Vehiculo elimando exitosamente: " + id);
    }

    @Override
    public List<VehicleDto> getByFuelType(String type) {
        List<VehicleDto> encontrados = mapVehiclesToVehiclesDto(vehicleRepository.getByFuelType(type));
        if(encontrados.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return encontrados;
    }

    @Override
    public List<VehicleDto> getByTransmissionType(String type) {
        List<VehicleDto> encontrados = mapVehiclesToVehiclesDto(vehicleRepository.getByTransmissionType(type));
        if(encontrados.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return encontrados;
    }

}
