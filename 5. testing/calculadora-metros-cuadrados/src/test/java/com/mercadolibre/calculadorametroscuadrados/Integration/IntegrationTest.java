package com.mercadolibre.calculadorametroscuadrados.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Annotate the class for Spring Boot testing
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    @Autowired
    MockMvc mockMvc;

    // ObjectWriter to convert objects to JSON with specific serialization settings
    private final ObjectWriter objectWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

    @Test
    @DisplayName("Test method for calculate rest")
    void calculateOKTest() throws Exception {
        // Create a response DTO
        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Room 1");
        roomDTO1.setLength(4);
        roomDTO1.setWidth(4);

        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Room 2");
        roomDTO2.setLength(2);
        roomDTO2.setWidth(2);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House 1");
        houseDTO.setAddress("abc 123");
        houseDTO.setRooms(List.of(roomDTO1, roomDTO2));

        HouseResponseDTO responseDTO = new HouseResponseDTO(houseDTO);
        responseDTO.setSquareFeet(20);
        responseDTO.setPrice(16000);
        responseDTO.setBiggest(roomDTO1);

        // Convert response DTO to JSON
        String requestPayloadJson = this.objectWriter.writeValueAsString(houseDTO);
        String responsePayloadJson = this.objectWriter.writeValueAsString(responseDTO);

        // Perform a POST request to calculate and expect an OK response
        MvcResult mvcResult = this.mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(requestPayloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(20))  // Check squareFeet field
                .andExpect(jsonPath("$.price").value(16000))      // Check price field
                .andExpect(jsonPath("$.biggest.name").value("Room 1"))  // Check biggest room name field
                .andReturn();

        // Assert that the response content matches the expected JSON
        assertEquals(responsePayloadJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test method for calculate rest with 0, biggest the first room")
    void calculateOKZeroTest() throws Exception {
        // Create a response DTO
        RoomDTO roomDTO1 = new RoomDTO();
        roomDTO1.setName("Room 1");
        roomDTO1.setLength(0);
        roomDTO1.setWidth(0);

        RoomDTO roomDTO2 = new RoomDTO();
        roomDTO2.setName("Room 2");
        roomDTO2.setLength(0);
        roomDTO2.setWidth(0);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House 1");
        houseDTO.setAddress("abc 123");
        houseDTO.setRooms(List.of(roomDTO2, roomDTO1));

        HouseResponseDTO responseDTO = new HouseResponseDTO(houseDTO);
        responseDTO.setSquareFeet(0);
        responseDTO.setPrice(0);
        responseDTO.setBiggest(roomDTO2);

        // Convert response DTO to JSON
        String requestPayloadJson = this.objectWriter.writeValueAsString(houseDTO);
        String responsePayloadJson = this.objectWriter.writeValueAsString(responseDTO);

        // Perform a POST request to calculate and expect an OK response
        MvcResult mvcResult = this.mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(requestPayloadJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        // Assert that the response content matches the expected JSON
        assertEquals(responsePayloadJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
    
}
