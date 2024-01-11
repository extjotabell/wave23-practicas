package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JewelDTO;
import com.example.joyerialasperlas.dto.JoyaIdDTO;
import com.example.joyerialasperlas.service.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/jewerly")
public class JoyaController {

  private IJoyaService service;

  public JoyaController(IJoyaService service) {
    this.service = service;
  }

  @PostMapping("/new")
  public ResponseEntity<JoyaIdDTO> createJoya(@RequestBody JewelDTO jewel) {

  }
}
