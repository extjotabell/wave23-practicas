package com.meli.jewelry.controllers;


import com.meli.jewelry.dtos.request.JewelDTO;
import com.meli.jewelry.services.IJewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/jewels")
public class JewelController {

    private final IJewelService jewelService;

    public JewelController(IJewelService jewelService) {
        this.jewelService = jewelService;
    }

    @PostMapping
    public ResponseEntity<Long> createJewel(@RequestBody JewelDTO jewelDTO){
        return ResponseEntity.ok(jewelService.createJewel(jewelDTO));
    }

    @GetMapping
    public ResponseEntity<List<JewelDTO>> getAllJewels(){
        return ResponseEntity.ok(jewelService.getAllJewels());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJewel(@PathVariable Long id)  {
        jewelService.deleteJewel(id);
        return ResponseEntity.ok().build();
    }
}