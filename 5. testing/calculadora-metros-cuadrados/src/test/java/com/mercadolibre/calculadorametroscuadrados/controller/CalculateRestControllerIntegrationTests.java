package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.HouseDTODataTestBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private HouseDTODataTestBuilder houseDTODataTestBuilder;

    @BeforeEach
    public void setup() {
        houseDTODataTestBuilder = new HouseDTODataTestBuilder();
    }

    @Test
    void calculateHouseWithMultipleRoomsShouldReturnCorrectResponse() throws Exception {
        HouseDTO house = houseDTODataTestBuilder.createByDefault().build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(45))
                .andExpect(jsonPath("$.biggest.name").value("Cocina"))
                .andExpect(jsonPath("$.price").value(36000));
    }

    @Test
    void calculateHouseWithOneRoomShouldReturnCorrectResponse() throws Exception {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1",5,5).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(25))
                .andExpect(jsonPath("$.biggest.name").value("Room1"))
                .andExpect(jsonPath("$.price").value(20000));
    }

    @Test
    void calculateWithEmptyRoomsListShouldReturnBadResponse() throws Exception {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(0))
                .andExpect(jsonPath("$.price").value(0));

    }

    @Test
    void calculateHouseWithZeroDimensionsRoomShouldIgnoreRoom() throws Exception {
        HouseDTO house = houseDTODataTestBuilder.createByDefaultWithoutRooms().withRoom("Room1",0,0).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(house)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.squareFeet").value(0))
                .andExpect(jsonPath("$.biggest.name").value("Room1"))
                .andExpect(jsonPath("$.price").value(0));
    }

}
