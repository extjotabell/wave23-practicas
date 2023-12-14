package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    // EJERCICIO 1
    @Override
    public void agregarVehiculo(VehicleDto vehicleDto) throws BadRequestException, ConflictException {
        ObjectMapper mapper = new ObjectMapper();
        //validar id
        if (vehicleRepository.existeId(vehicleDto.getId())){
            throw new ConflictException("Identificador del vehículo ya existente");
        }
        //validar formato
        if (vehicleRepository.formatoValido(mapper.convertValue(vehicleDto,Vehicle.class))){
            throw new BadRequestException("Datos del vehículo mal formados o incompletos");
        }

        vehicleRepository.agregarVehiculo(mapper.convertValue(vehicleDto,Vehicle.class));

    }

    // EJERCICIO 2
    @Override
    public List<VehicleDto> buscarColoryear(String color, Integer year) {
        List<Vehicle> listaVehicles = vehicleRepository.buscarColoryear(color,year);

        if (listaVehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> listaVehiclesDto = new ArrayList<>();

        listaVehiclesDto = listaVehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).collect(Collectors.toList());

        return listaVehiclesDto;
    }

    // EJERCICIO 3
    @Override
    public List<VehicleDto> buscarMarcaYears(String brand, int start_year, int end_year) {
        List<Vehicle> listaVehicleOK = vehicleRepository.buscarMarcaYears(brand,start_year,end_year);

        if (listaVehicleOK.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> listaVehicleDto = new ArrayList<>();

        listaVehicleDto = listaVehicleOK.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).collect(Collectors.toList());
        return listaVehicleDto;
    }


    //EJERCICIO 4
    @Override
    public String buscarVelocidadPromMarca(String brand) {
        double velocidadProm = vehicleRepository.buscarVelocidadPromMarca(brand);
        String mensaje = "";
        if (velocidadProm != 0.0){
            mensaje = "Velocidad promedio marca " + brand + ": " +velocidadProm;
        } else {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        return mensaje;
    }

    // EJERCICIO 5
    @Override
    public void agregaBatch(List<VehicleDto> listavehiculos) throws ConflictException, BadRequestException {
        for (VehicleDto vAgregar : listavehiculos){

            ObjectMapper mapper = new ObjectMapper();
            //validar id
            if (vehicleRepository.existeId(vAgregar.getId())){
                throw new ConflictException("Identificador del vehículo ya existente");
            }
            //validar formato
            if (vehicleRepository.formatoValido(mapper.convertValue(vAgregar,Vehicle.class))){
                throw new BadRequestException("Datos del vehículo mal formados o incompletos");
            }

            vehicleRepository.agregarVehiculo(mapper.convertValue(vAgregar,Vehicle.class));
        }
    }

    //EJERCICIO 6
    @Override
    public void updateVelocidadxTipo(Long id, VehicleDto vehicleDto) throws ConflictException {
        //validar id
        Vehicle existingVehicle = vehicleRepository.buscarId(id);

        if (existingVehicle!=null){
            // Realizar la actualización
            existingVehicle.setMax_speed(vehicleDto.getMax_speed());

            vehicleRepository.updateVelocidadxTipo(existingVehicle);

        }else {
            throw new NotFoundException("No se encontró el vehículo");
        }


    }

    // EJERCICIO 7
    @Override
    public List<VehicleDto> buscarMarcaYear(String type) {
        List<Vehicle> listaOk = vehicleRepository.buscarMarcaYear(type);

        if (listaOk.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> listaVehicleDto = new ArrayList<>();

        listaVehicleDto = listaOk.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).collect(Collectors.toList());
        return listaVehicleDto;

    }

    // EJERCICIO 8
    @Override
    public void eliminarVehiculoId(Long id) {
        Vehicle vehicleId = vehicleRepository.buscarId(id);
        if (vehicleId == null){
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicleRepository.eliminarVehiculoId(id);
    }

    // EJERCICIO 9
    @Override
    public List<VehicleDto> buscarTransmision(String type) {
        List<Vehicle> vehiculosOK = vehicleRepository.buscarTransmision(type);

        if (vehiculosOK.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> listaOkDto = new ArrayList<>();
        listaOkDto = vehiculosOK.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).collect(Collectors.toList());

        return listaOkDto;
    }

    // EJERCICIO 10
    @Override
    public void actualizarTipoCombustible(Long id, VehicleDto vehicleDto) throws BadRequestException {

        ObjectMapper mapper = new ObjectMapper();

        //validar formato
        if (vehicleDto == null){
            throw new BadRequestException(" Tipo de combustible mal formado o no admitido.");
        }

        Vehicle existingVehicle = vehicleRepository.buscarId(id);

        if (existingVehicle!=null){

            existingVehicle.setFuel_type(vehicleDto.getFuel_type());

            vehicleRepository.actualizarTipoCombustible(existingVehicle);

        }else {
            throw new NotFoundException(" No se encontró el vehículo");
        }
    }
    //EJERCICIO 11
    @Override
    public double capacidadPromedioMarca(String brand) {
        List<Vehicle> vehiclesListMarca = vehicleRepository.capacidadPromedioMarca(brand);
        if (vehiclesListMarca.isEmpty()){
            throw new NotFoundException("o se encontraron vehículos de esa marca");
        }

        double sumaCapacidades = 0.0;
        for (Vehicle vehicle : vehiclesListMarca) {
            sumaCapacidades += vehicle.getPassengers();
        }

        double capacidadPromedio = sumaCapacidades / vehiclesListMarca.size();

        return capacidadPromedio;
    }

    // EJERCICIO 12
    @Override
    public List<VehicleDto> buscarDimensiones(Double min_width, Double max_width, Double min_height, Double max_height) {
        List<Vehicle> listaOk = vehicleRepository.buscarDimensiones(min_width,max_width,min_height,max_height);

        if (listaOk.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> listaVehicleDto = new ArrayList<>();

        listaVehicleDto = listaOk.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).collect(Collectors.toList());
        return listaVehicleDto;

    }

    // EJERCICIO 13
    @Override
    public List<VehicleDto> buscarRangoPeso(Double weight_min, Double weight_max) {
        List<Vehicle> listaOk = vehicleRepository.buscarRangoPeso(weight_min,weight_max);

        if (listaOk.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }

        ObjectMapper mapper = new ObjectMapper();
        List<VehicleDto> vehicleDtoList = new ArrayList<>();

        vehicleDtoList = listaOk.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class)).collect(Collectors.toList());
        return vehicleDtoList;
    }


}
