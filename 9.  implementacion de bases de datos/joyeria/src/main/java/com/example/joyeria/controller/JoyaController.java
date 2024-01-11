package com.example.joyeria.controller;

import com.example.joyeria.dto.JoyaDto;
import com.example.joyeria.dto.ListJoyaDto;
import com.example.joyeria.dto.MessageDto;
import com.example.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private final JoyaService service;

    public JoyaController(JoyaService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> addJoya(@RequestBody JoyaDto joya) {
        return new ResponseEntity<>(service.addJoya(joya), HttpStatus.OK);

    }
    @PostMapping("/update/{id}")
    public ResponseEntity<JoyaDto> updateJoya(@RequestBody JoyaDto joya, @PathVariable Long id) {
        return new ResponseEntity<>(service.updateJoya(joya, id), HttpStatus.OK);

    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<ListJoyaDto> deleteJoya(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteJoya(id), HttpStatus.OK);

    }
    @GetMapping("/list")
    public ResponseEntity<ListJoyaDto> getJoyasList() {
        return new ResponseEntity<>(service.getJoyasList(), HttpStatus.OK);
    }
}
