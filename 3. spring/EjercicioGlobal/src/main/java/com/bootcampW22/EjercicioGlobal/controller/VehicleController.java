package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.BadRequestException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    //1 AÑADIR VEHICULO
    @PostMapping("/vehicles")
    public ResponseEntity<?> agregarVehiculo(@RequestBody VehicleDto vehicleDto) throws BadRequestException, ConflictException {
        vehicleService.agregarVehiculo(vehicleDto);
        return new ResponseEntity<>("Vehículo creado exitosamente",HttpStatus.CREATED);
    }

    //2 BUSCAR VEHICULO X COLO Y AÑO
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?>buscarColoryear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.buscarColoryear(color,year), HttpStatus.OK);
    }

    //3 BUSCAR VEHICULO X MARCA Y RANGO AÑO
    @GetMapping("vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?>buscarMarcaYears(@PathVariable String brand, @PathVariable int start_year, @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.buscarMarcaYears(brand,start_year,end_year), HttpStatus.OK);
    }

    //4 BUSCAR VELOCIDAD PROMEDIO POR MARCA
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?>buscarVelocidadPromMarca(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.buscarVelocidadPromMarca(brand),HttpStatus.OK);
    }

    //5 AÑADIR VARIOS VEHICULOS
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?>agregaBatch(@RequestBody List<VehicleDto> listavehiculos) throws ConflictException, BadRequestException {
        vehicleService.agregaBatch(listavehiculos);
        return new ResponseEntity<>("Vehículos creados exitosamente", HttpStatus.CREATED);
    }

    //6 ACTUALIZAR VELOCIDAD MAXIMA DE UN TIPO DE VEHICULO
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?>updateVelocidadxTipo(@PathVariable Long id,@RequestBody VehicleDto vehicleDto ) throws ConflictException {
        vehicleService.updateVelocidadxTipo(id, vehicleDto);
        return new ResponseEntity<>("Velocidad del vehículo actualizada exitosamente", HttpStatus.OK);
    }

    //7 BUSCAR VEHICULO X TIPO COMBUSTIBLE
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?>buscarMarcaYear(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.buscarMarcaYear(type),HttpStatus.OK);
    }

    //8 ELIMINAR VEHICULO
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?>eliminarVehiculoId(@PathVariable Long id){
        vehicleService.eliminarVehiculoId(id);
        return new ResponseEntity<>("Vehículo eliminado exitosamente.", HttpStatus.NO_CONTENT);
    }

    //9 BUSCAR VEHICULO X TIPO DE TRANSMISION
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> buscarTransmision(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.buscarTransmision(type), HttpStatus.OK);
    }

    // 10 ACTUALOZAR TIPO DE COMBUSTIBLE
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?>actualizarTipoCombustible(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) throws BadRequestException {
        vehicleService.actualizarTipoCombustible(id, vehicleDto);
        return new ResponseEntity<>("Tipo de combustible del vehículo actualizado exitosamente", HttpStatus.OK);
    }

    // 11 CAPACIDAD PROMEDIO DE PEROSNA X MARCA
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> capacidadPromedioMarca(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.capacidadPromedioMarca(brand), HttpStatus.OK);
    }

    //12 BUSCAR POR DIMENSION
    @GetMapping("/vehicles/dimensions/length={min_length}-{max_length}&width={min_width}-{max_width}")
    public ResponseEntity<?> buscarDimensiones(@PathVariable Double min_length, @PathVariable Double max_length, @PathVariable Double min_width, @PathVariable Double max_width){
        return new ResponseEntity<>(vehicleService.buscarDimensiones(min_length,max_length,min_width,max_width), HttpStatus.OK);
    }

    //13 LISTAR POR RANGO DE PESO
    @GetMapping("/vehicles/weight/min={weight_min}&max={weight_max}")
    public ResponseEntity<?> buscarRangoPeso(@PathVariable Double weight_min, @PathVariable Double weight_max){
        return new ResponseEntity<>(vehicleService.buscarRangoPeso(weight_min,weight_max), HttpStatus.OK);
    }

}
