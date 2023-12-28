package com.mercadolibre.calculadorametroscuadrados.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import com.mercadolibre.calculadorametroscuadrados.util.FactoryDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void writer(){
        writer =  new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void calculateTest() throws Exception{

        HouseDTO payload = FactoryDTO.factoryHouseDTO();

        String payloadJson = writer.writeValueAsString(payload);

        HouseResponseDTO evaluate = FactoryDTO.factoryHouseResponseDTO(payload, 950,
                760000, FactoryDTO.factoryRoomDTO("Room 1", 10,50));

        String evaluateString = writer.writeValueAsString(evaluate);

        MvcResult mvcResult = this.mockMvc.perform(post("/calculate")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Prueba"))
                .andReturn();

        Assertions.assertEquals(evaluateString, mvcResult.getResponse().getContentAsString());
    }

    @Test
    void calculateNullTes() throws Exception {
        HouseDTO payload = new HouseDTO();
        payload.setName("Test 1");
        payload.setAddress("Address Test");
        payload.setRooms(new ArrayList<RoomDTO>());

        String payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms").value(new ArrayList<>()))
                .andReturn();
    }

}
