package com.meli.JoyeriaLasPerlas.controller;

import com.meli.JoyeriaLasPerlas.dto.request.JewelRequestDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewelResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.JewerlyResponseDTO;
import com.meli.JoyeriaLasPerlas.dto.response.ResponseDTO;
import com.meli.JoyeriaLasPerlas.entity.Jewel;
import com.meli.JoyeriaLasPerlas.service.JewelServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    private final JewelServiceImpl jewelService;

    public JewelController(JewelServiceImpl jewelService){
        this.jewelService = jewelService;
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> createJewel(@RequestBody JewelRequestDTO jewelRequestDTO){
        return new ResponseEntity<>(jewelService.createJewel(jewelRequestDTO), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<JewerlyResponseDTO> getListJewerly(){
        return new ResponseEntity<>(jewelService.getJewerly(), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteJewel(@PathVariable Long id){
        return new ResponseEntity<>(jewelService.deleteJewel(id), HttpStatus.OK);
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<JewelResponseDTO> modifyJewel(@PathVariable Long id_modificar,
                                                        @RequestBody JewelRequestDTO jewelRequestDTO){
        return new ResponseEntity<>(jewelService.modifyJewel(id_modificar, jewelRequestDTO), HttpStatus.OK);
    }

}
