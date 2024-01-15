package com.meli.bootcamp.empresaseguros.controller;

import com.meli.bootcamp.empresaseguros.dto.VehiculoDto;
import com.meli.bootcamp.empresaseguros.service.EmpresaServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/seguros")
public class EmpresaController {
    private EmpresaServiceImpl service;

    public EmpresaController(EmpresaServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/vehiculos")
    public ResponseEntity<List<VehiculoDto>> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/findByPatente")
    public ResponseEntity<?> findByPatente(){
        return new ResponseEntity<>(service.findByPatente(), HttpStatus.OK);
    }

    @GetMapping("/findByPatenteMarca")
    public ResponseEntity<?> findByPatenteMarca(){
        return new ResponseEntity<>(service.findByPatenteMarca(), HttpStatus.OK);
    }

    @GetMapping("/findByCurrentYear")
    public ResponseEntity<List<VehiculoDto>> findByCurrentYear(){
        return new ResponseEntity<>(service.findByCurrentYear(), HttpStatus.OK);
    }

    @GetMapping("/findByPMM")
    public ResponseEntity<?> findByPMM(){
        return new ResponseEntity<>(service.findByPMM(), HttpStatus.OK);
    }


}
