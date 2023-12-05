package com.meli.numerosromanos.controller;

import com.meli.numerosromanos.service.RomansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("romans")
public class RomansController {
    @Autowired
    private RomansService rs;

    @GetMapping("/{number}")
    public String getRomanNumber(@PathVariable int number){
        return rs.getRomanNumber(number);
    }
}
