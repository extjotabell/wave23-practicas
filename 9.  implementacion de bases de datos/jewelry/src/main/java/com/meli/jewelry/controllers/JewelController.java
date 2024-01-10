package com.meli.jewelry.controllers;


import com.meli.jewelry.dtos.JewelDTO;
import com.meli.jewelry.services.IJewelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
