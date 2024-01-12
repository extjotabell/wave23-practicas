package com.meli.Vehiculos.controller;

import com.meli.Vehiculos.dto.request.VehiculoRequestDTO;
import com.meli.Vehiculos.dto.response.VehiculoResponseDTO;
import com.meli.Vehiculos.service.IVehiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody VehiculoRequestDTO vehiculoDTO) {
        VehiculoResponseDTO response = vehiculoService.save(vehiculoDTO);
        return ResponseEntity.status(201).body(response);
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<VehiculoResponseDTO> response = vehiculoService.findAll();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        VehiculoResponseDTO response = vehiculoService.findById(id);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/patentes")
    public ResponseEntity<?> getAllPatentes() {
        List<String> response = vehiculoService.findAllPatentes();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/ordenados-por-fabricacion")
    public ResponseEntity<?> getAllPatentesAndMarcaOrderByYearFabricacion() {
        List<VehiculoResponseDTO> response = vehiculoService.findAllPatentesAndMarcaOrderByYearFabricacion();
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/patentes/{cantidadRuedas}/{yearFabricacion}")
    public ResponseEntity<?> getAllPatentesByCantidadRuedasAndYearFabricacion(@PathVariable Integer cantidadRuedas, @PathVariable Integer yearFabricacion) {
        List<String> response = vehiculoService.findAllPatentesByCantidadRuedasAndYearFabricacion(cantidadRuedas, yearFabricacion);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/siniestros-mayores-a/{perdidaEconomicaSiniestro}")
    public ResponseEntity<?> getAllByPerdidaEconomicaSiniestroIsGreaterOrEqualThan(@PathVariable Double perdidaEconomicaSiniestro) {
        List<VehiculoResponseDTO> response = vehiculoService.findAllByPerdidaEconomicaSiniestroIsGreaterOrEqualThan(perdidaEconomicaSiniestro);
        return ResponseEntity.status(200).body(response);
    }

    @GetMapping("/siniestros-mayores-a/{perdidaEconomicaSiniestro}/total")
    public ResponseEntity<?> getVehiclesWithTotalLossGreaterThan(@PathVariable Double perdidaEconomicaSiniestro) {
        List<VehiculoResponseDTO> response = vehiculoService.findVehiclesWithTotalLossGreaterThan(perdidaEconomicaSiniestro);
        return ResponseEntity.status(200).body(response);
    }
}
