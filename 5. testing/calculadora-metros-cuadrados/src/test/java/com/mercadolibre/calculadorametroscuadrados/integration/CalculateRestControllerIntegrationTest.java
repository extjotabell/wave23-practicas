package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.mercadolibre.calculadorametroscuadrados.util.UtilsTest.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void calculateIntegrationTest() throws Exception {
        // Arrange
        RoomDTO roomForHouse = getRoomDTO("Ofice", 3, 5);
        HouseDTO requestHouseDTO = getHouseDTO("PH", "Calle 123", List.of(roomForHouse));
        HouseResponseDTO houseResponseDTO = getResponseHouseDTO(requestHouseDTO, roomForHouse);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String requestPayloadJson = writer.writeValueAsString(requestHouseDTO);
        String responsePayloadJson = writer.writeValueAsString(houseResponseDTO);


        // Act
        this.mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(requestPayloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json")) // Type-Content
                .andExpect(status().isOk()) // Code
                .andExpect(content().json(responsePayloadJson)); // Body
    }
}
