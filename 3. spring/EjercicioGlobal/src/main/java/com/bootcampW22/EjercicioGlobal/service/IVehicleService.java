package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IVehicleService {
    // EJERCICIO 1
    List<VehicleDto> searchAllVehicles();
    void agregarVehiculo(VehicleDto vehicleDto) throws BadRequestException, ConflictException;
    //EJERCICIO 2
    List<VehicleDto>buscarColoryear(String color, Integer year);
    //EJERCICIO 3
    List<VehicleDto>buscarMarcaYears(String brand ,int start_year, int end_year);
    //EJERCICIO 4
    String buscarVelocidadPromMarca(String brand);
    //EJERCICIO 5
    void agregaBatch(List<VehicleDto> listavehiculos) throws ConflictException, BadRequestException;
    //EJERCICIO 6
    void updateVelocidadxTipo(Long id,VehicleDto vehicleDto ) throws ConflictException;
    //EJERCICIO 7
    List<VehicleDto>buscarMarcaYear(String type);
    //EJERCICIO 8
    void eliminarVehiculoId(Long id);
    //EJERCICIO 9
    List<VehicleDto>buscarTransmision(String type);
    //EJERCICIO 10
    void actualizarTipoCombustible(Long id, VehicleDto vehicleDto) throws BadRequestException;
    //EJERCICIO 11
    double capacidadPromedioMarca(String brand);
    //EJERCICIO 12
    List<VehicleDto> buscarDimensiones(Double min_width, Double max_width, Double min_height,Double max_height);
    //EJERCICIO 12
    List<VehicleDto> buscarRangoPeso(Double weight_min, Double weight_max);
}
