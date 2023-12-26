package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateRestController {
  private CalculateService service;

  public CalculateRestController(CalculateService service) {
    this.service = service;
  }

  @PostMapping("/calculate")
  public HouseResponseDTO calculate(@RequestBody HouseDTO house) {
    return service.calculate(house);
  }
}
