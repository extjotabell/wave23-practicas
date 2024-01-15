package com.example.segurosHQL.controller;

import com.example.segurosHQL.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiculoController {
    @Autowired
    VehiculoService service;

    //Listar todos los vehiculos
    @GetMapping("/vehiculos")
    ResponseEntity<?> getVehiculos(){
        return new ResponseEntity<>(service.getVehiculos(), HttpStatus.CREATED);
    }

    //Listar las patentes de todos los vehículos registrados.
    @GetMapping("/patentes")
    ResponseEntity<?> getPatentes(){
        return new ResponseEntity<>(service.getPatentes(), HttpStatus.OK);
    }

    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @GetMapping("/patentesOrder")
    ResponseEntity<?> getPatentesByAnio(){
        return new ResponseEntity<>(service.getPatentesByAnio(), HttpStatus.OK);
    }

    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados en el corriente año.
    @GetMapping("/patentesAnioRuedas")
    ResponseEntity<?> patentesAnioRuedas(){
        return new ResponseEntity<>(service.patentesAnioRuedas(), HttpStatus.OK);
    }

    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @GetMapping("/perdidamayor")
    ResponseEntity<?> perdidamayor(){
        return new ResponseEntity<>(service.perdidamayor(), HttpStatus.OK);
    }
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de 10000 pesos
    // y mostrar a cuánto ascendió la pérdida total de todos ellos.
    @GetMapping("/perdidamayorvista")
    ResponseEntity<?> perdidamayorvista(){
        return new ResponseEntity<>(service.perdidamayorvista(), HttpStatus.OK);
    }
}
