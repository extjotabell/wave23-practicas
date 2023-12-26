package service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest {

    @InjectMocks
    private CalculateService calculateService;

    @Test
    @DisplayName("CalculateService - calculate: Verificar que el DTO tiene el precio correcto")
    void calculateTestPrice() {
        // Arrange
        HouseDTO initial = getTestHouse();
        // Act
        HouseResponseDTO actual =  calculateService.calculate(initial);
        HouseResponseDTO expected = new HouseResponseDTO(initial, 36,  28800, initial.getRooms().get(0));
        // Assert
        Assertions.assertEquals(expected.getPrice(), actual.getPrice());
    }

    @Test
    @DisplayName("CalculateService - calculate: Verificar que el DTO tiene el squareFeet correcto")
    void calculateTestSquareFeet() {
        // Arrange
        HouseDTO initial = getTestHouse();
        // Act
        HouseResponseDTO actual =  calculateService.calculate(initial);
        HouseResponseDTO expected = new HouseResponseDTO(initial, 36,  28800, initial.getRooms().get(0));
        // Assert
        Assertions.assertEquals(expected.getSquareFeet(), actual.getSquareFeet());
    }

    @Test
    @DisplayName("CalculateService - calculate: Verificar que el DTO tiene el cuarto grande correcto")
    void calculateTestBiggest() {
        // Arrange
        HouseDTO initial = getTestHouse();
        // Act
        HouseResponseDTO actual =  calculateService.calculate(initial);
        HouseResponseDTO expected = new HouseResponseDTO(initial, 36,  28800, initial.getRooms().get(0));
        // Assert
        Assertions.assertEquals(expected.getBiggest(),  actual.getBiggest());
    }

    private HouseDTO getTestHouse() {
        return new HouseDTO("Casa Fer", "Iztapalapa", List.of(
                new RoomDTO("Cuarto grande", 5, 5),
                new RoomDTO("Cocina", 3, 3),
                new RoomDTO("Baño", 2, 1)
        ));
    }

}
