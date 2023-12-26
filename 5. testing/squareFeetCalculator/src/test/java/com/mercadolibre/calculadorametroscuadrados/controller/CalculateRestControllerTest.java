package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test to verify the endpoint method")
    void testFindEndpoint() throws Exception{

        RoomDTO room1 = new RoomDTO();
        room1.setName("Room1 of House 1");
        room1.setWidth(5);
        room1.setLength(5);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Room2 of House 1");
        room2.setWidth(8);
        room2.setLength(10);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House1");
        houseDTO.setAddress("Address1");
        houseDTO.setRooms(Arrays.asList(room1, room2));

        // Convert houseDTO to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String houseDTOJson = objectMapper.writeValueAsString(houseDTO);

        this.mockMvc.perform(post("/calculate")
                    .content(houseDTOJson)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value("House1"))
                    .andReturn();
    }

    @Test
    @DisplayName("Test to verify the endpoint method for not found")
    void testBadRequest() throws Exception{

        RoomDTO room1 = new RoomDTO();
        room1.setName("Room1 of House 1");
        room1.setWidth(5);
        room1.setLength(5);
        RoomDTO room2 = new RoomDTO();
        room2.setName("Room2 of House 1");
        room2.setWidth(8);
        room2.setLength(10);

        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House1");
        houseDTO.setAddress("Address1");
        houseDTO.setRooms(Arrays.asList(room1, room2));

        ObjectMapper objectMapper = new ObjectMapper();
        String houseDTOJson = objectMapper.writeValueAsString(houseDTO);

        this.mockMvc.perform(post("/calculates")
                    .content(houseDTOJson)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isNotFound())
                    .andExpect(content().string(""))
                    .andReturn();
    }



}
