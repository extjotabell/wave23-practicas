package com.mercadolibre.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.demo.dtos.JewelDTO;
import com.mercadolibre.demo.dtos.MessageDTO;
import com.mercadolibre.demo.models.Jewel;
import com.mercadolibre.demo.services.JewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelersController {
    @Autowired
    private JewelService service;

    @PostMapping("/new")
    public MessageDTO createJewerly(@RequestBody JewelDTO jewerly){
        return service.saveJewel(new ObjectMapper().convertValue(jewerly, Jewel.class));
    }

    @GetMapping("/")
    public List<JewelDTO> getAll(){
        return service.getAll();
    }

    @PutMapping("/delete/{id}")
    public MessageDTO deleteJewerly(@PathVariable Long id) {
        return service.deleteJewel(id);
    }

    @PutMapping("/update/{id}")
    public MessageDTO updateJewel(@PathVariable Long id,@RequestBody JewelDTO jewel){
        return service.updateJewel(id, jewel);
    }
}
