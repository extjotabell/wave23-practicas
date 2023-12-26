package com.mercadolibre.calculadorametroscuadrados.integration;


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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
    MockMvc mockMvc;

    @Test
    @DisplayName("calculate integration test")
    void calculateTest() throws Exception {

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        RoomDTO roomDTO = new RoomDTO("Comedor", 10, 10);
        HouseDTO houseDTO = new HouseDTO("Casa", "test", List.of(roomDTO));
        HouseResponseDTO response = new HouseResponseDTO(houseDTO);
        response.setBiggest(roomDTO);
        response.setPrice(80000);
        response.setSquareFeet(100);

        String payloadJson = objectWriter.writeValueAsString(houseDTO);
        String responseJson = objectWriter.writeValueAsString(response);

        MvcResult result = this.mockMvc.perform(
                post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson, result.getResponse().getContentAsString());
    }
}
