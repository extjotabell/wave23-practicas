package com.bootcampW22.EjercicioGlobal.repository;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.List;

public interface IVehicleRepository {
    Vehicle buscarId(Long id);

    // EJERCICIO 1
    List<Vehicle> findAll();
    void agregarVehiculo(Vehicle vehicle);
    Boolean existeId (Long id);
    Boolean formatoValido (Vehicle Vehicle);
    // EJECICIO 2
    List<Vehicle>buscarColoryear(String color, Integer year);
    //EJERCICIO 3
    List<Vehicle>buscarMarcaYears(String brand, Integer start_year, Integer end_year);
    //EJERCICIO 4
    double buscarVelocidadPromMarca(String brand);
    //5 ANADIR MULTIPLES VELICLUOS MISMO // EJERCICIO 1
    //EJERCICIO 6
    void updateVelocidadxTipo(Vehicle vehicle);
    //EJECICIO 7
    List<Vehicle> buscarMarcaYear(String type);
    //EJERCICIO 8
    void eliminarVehiculoId(Long id);
    //EJERCICIO 9
    List<Vehicle> buscarTransmision(String type);
    //EJERCICIO 10
    void actualizarTipoCombustible(Vehicle vehicle);
    //EJERCICIO 11
    List<Vehicle>capacidadPromedioMarca(String brand);
    //EJERCICIO 12
    List<Vehicle> buscarDimensiones(Double min_width, Double max_width,Double min_height,Double max_height);
    //EJERCICIO 13
    List<Vehicle>buscarRangoPeso(Double weight_min, Double weight_max);
}
