package com.mercadolibre.calculadorametroscuadrados.controller;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.utils.Builder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculateRestControllerTest {
    @Mock
    CalculateService service;
    @InjectMocks
    CalculateRestController controller;
    private HouseDTO houseDTO;

    @BeforeEach
    void initialize() {
        houseDTO = new HouseDTO();
        houseDTO.setName("Family house");
        houseDTO.setAddress("742 Evergreen Terrace");
        houseDTO.setRooms(Builder.buildRoomsDTO());
    }

    @Test
    @DisplayName("Test calculate successfully")
    void testCalculateOk() {
        HouseDTO param = houseDTO;
        HouseResponseDTO expectedResult = Builder.buildResponseDTO(param);

        when(service.calculate(param)).thenReturn(expectedResult);
        HouseResponseDTO result = service.calculate(param);

        verify(service, atLeastOnce()).calculate(param);
        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Test calculate with null request")
    void testCalculateWithNullRequest() {
        HouseDTO param = null;

        assertThrows(NullPointerException.class,
                () -> controller.calculate(param));
    }

}