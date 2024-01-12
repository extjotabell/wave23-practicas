package com.mercadolibre.composite.controller;

import com.mercadolibre.composite.entities.Buy;
import com.mercadolibre.composite.exception.BadRequestException;
import com.mercadolibre.composite.service.BuyServiceImpl;
import com.mercadolibre.composite.service.IBuyService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyController {

    IBuyService buyService;

    public BuyController(BuyServiceImpl buyService) {
        this.buyService = buyService;
    }
    @PostMapping("/buys")
    public ResponseEntity<String> createJewel(@RequestBody Buy buy) {
        buyService.saveBuy(buy);
        return new ResponseEntity<>("Compra creada correctamente", HttpStatus.OK);
    }
}

