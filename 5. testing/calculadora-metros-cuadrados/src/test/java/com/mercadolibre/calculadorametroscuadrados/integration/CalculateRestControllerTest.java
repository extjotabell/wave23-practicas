package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.controller.CalculateRestController;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {
    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void calculateTestOk() throws Exception {
        RoomDTO room = new RoomDTO("room1", 10, 10);
        List<RoomDTO> rooms = List.of(room);
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle falsa", rooms);
        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO(100, 80000, room);

        String houseDTOJson = writer.writeValueAsString(houseDTO);
        System.out.println(houseDTOJson);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseDTOJson))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(expectedResponseDTO.getPrice()))
                .andExpect(jsonPath("$.squareFeet").value(expectedResponseDTO.getSquareFeet()))
                .andExpect(jsonPath("$.biggest.name").value(expectedResponseDTO.getBiggest().getName()));


    }

    @Test
    void calculateWithEmptyHouseTestBadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    void calculateWithHouseZeroRoomsTestOk() throws Exception {
        HouseDTO houseDTO = new HouseDTO("Casa", "Calle falsa", new ArrayList<>());
        String houseDTOJson = writer.writeValueAsString(houseDTO);
        System.out.println(houseDTOJson);
        HouseResponseDTO expectedResponseDTO = new HouseResponseDTO(0, 0, null);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(houseDTOJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(0))
                .andExpect(jsonPath("$.squareFeet").value(0))
                .andExpect(jsonPath("$.biggest").value(expectedResponseDTO.getBiggest()));
    }
}
