package meli.bootcamp.spring.learning.ej9.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.spring.learning.ej9.dto.request.PlatoRequestDto;
import meli.bootcamp.spring.learning.ej9.dto.response.PlatoResponseDto;
import meli.bootcamp.spring.learning.ej9.service.impl.PlatoService;

@RestController
@RequestMapping("ej9")
public class PlatoController {
  @Autowired
  private PlatoService service;

  @PostMapping()
  public ResponseEntity<PlatoResponseDto> calcular(@RequestBody PlatoRequestDto requestDto) {
    return ResponseEntity.ok(service.calcular(requestDto));
  }

  @PostMapping("multi")
  public ResponseEntity<List<PlatoResponseDto>> calcular(@RequestBody List<PlatoRequestDto> requestDto) {
    return ResponseEntity.ok(service.calcular(requestDto));
  }
}
