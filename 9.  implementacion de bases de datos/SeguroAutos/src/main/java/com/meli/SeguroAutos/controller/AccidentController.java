package com.meli.SeguroAutos.controller;

import com.meli.SeguroAutos.dto.AccidentRequestDTO;
import com.meli.SeguroAutos.dto.ResponseDTO;
import com.meli.SeguroAutos.dto.VehicleRequestDTO;
import com.meli.SeguroAutos.service.AccidentService;
import com.meli.SeguroAutos.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accidents")
public class AccidentController {

    private final AccidentService accidentService;

    public AccidentController(AccidentService accidentService){
        this.accidentService = accidentService;
    }

    @PostMapping("/new/{idVehicle}")
    public ResponseEntity<ResponseDTO> createAccident(@RequestBody AccidentRequestDTO accidentRequestDTO,
                                                      @PathVariable Long idVehicle){
        return new ResponseEntity<>(accidentService.createAccident(accidentRequestDTO, idVehicle), HttpStatus.CREATED);
    }

}
