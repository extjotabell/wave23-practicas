package com.mercadolibre.calculadorametroscuadrados.controller;

import static org.mockito.Mockito.when;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculateRestControllerTest {

  @Mock
  CalculateService service;

  @InjectMocks
  CalculateRestController controller;

  @Test
  void calculateHouseTest(){
    //Arrange
    HouseDTO houseDTO = new HouseDTO();
    HouseResponseDTO responseDTO = new HouseResponseDTO();
    when(service.calculate(houseDTO)).thenReturn(responseDTO);
    //Act
    HouseResponseDTO result = controller.calculate(houseDTO);
    //Assert
    Assertions.assertEquals(responseDTO, result);
  }
}
