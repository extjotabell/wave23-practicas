package com.example.seguroAutos.controller;

import com.example.seguroAutos.dto.AutoDto;
import com.example.seguroAutos.dto.MessageDto;
import com.example.seguroAutos.service.AutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoController {
     private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> addAuto(@RequestBody AutoDto auto) {
        return new ResponseEntity<>(autoService.addAuto(auto), HttpStatus.OK);

    }
    @GetMapping("/patentes")
    public ResponseEntity<?> getPatentes() {
        return new ResponseEntity<>(autoService.getPatentes(), HttpStatus.OK);
    }

}
