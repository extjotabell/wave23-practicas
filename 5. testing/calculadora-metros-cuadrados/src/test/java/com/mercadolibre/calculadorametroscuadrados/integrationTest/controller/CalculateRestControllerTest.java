package com.mercadolibre.calculadorametroscuadrados.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.service.CalculateService;
import com.mercadolibre.calculadorametroscuadrados.util.CreateHouseResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateOk() throws Exception{
        CreateHouseResponseDTO createHouseResponseDTO = new CreateHouseResponseDTO();

        HouseDTO dtoEntrada = new HouseDTO("Mi casa","Calle 123", List.of(
                new RoomDTO("Cocina",5,7),
                new RoomDTO("Dormitorio",4,6),
                new RoomDTO("Lavanderia",6,8)
        ));

        HouseResponseDTO expected = createHouseResponseDTO.createExpectedResponse();

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payload = objecTWriter.writeValueAsString(dtoEntrada);
        String responseExpected = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseExpected,mvcResult.getResponse().getContentAsString());
    }
    @Test
    void calculateNoRooms() throws Exception{
        CreateHouseResponseDTO createHouseResponseDTO = new CreateHouseResponseDTO();

        HouseDTO dtoEntrada = new HouseDTO("Mi casa","Calle 123", Collections.emptyList());

        HouseResponseDTO expected = createHouseResponseDTO.createExpectedNoRoomsResponse();

        ObjectWriter objecTWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payload = objecTWriter.writeValueAsString(dtoEntrada);
        String responseExpected = objecTWriter.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/calculate")
                        .contentType("application/json")
                        .content(payload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseExpected,mvcResult.getResponse().getContentAsString());
    }

}
