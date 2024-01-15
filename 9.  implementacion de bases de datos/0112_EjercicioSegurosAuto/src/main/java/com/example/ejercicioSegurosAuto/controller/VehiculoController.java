package com.example.ejercicioSegurosAuto.controller;

import com.example.ejercicioSegurosAuto.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    IVehiculoService vehiculoService;

    @GetMapping("/patentes")
    public ResponseEntity<?> findPatentes(){
        return ResponseEntity.ok(vehiculoService.findPatentes());
    }

    @GetMapping("/patentesMarcas")
    public ResponseEntity<?> findPatentesMarcas(){
        return ResponseEntity.ok(vehiculoService.findPatentesMarcas());
    }

    @GetMapping("/patenteAnioEnCurso")
    public ResponseEntity<?> findPatenteByCurrentYear(){
        return ResponseEntity.ok(vehiculoService.findPatenteByCurrentYear());
    }

    @GetMapping("/siniestroMayor10000")
    public ResponseEntity<?> findSiniestroGreaterThan10000(){
        return ResponseEntity.ok(vehiculoService.findSiniestroGreaterThan10000());
    }

    @GetMapping("/totalSiniestrosMayor10000")
    public ResponseEntity<?> findTotalMayor10000(){
        return ResponseEntity.ok(vehiculoService.findTotalMayor10000());
    }

}
