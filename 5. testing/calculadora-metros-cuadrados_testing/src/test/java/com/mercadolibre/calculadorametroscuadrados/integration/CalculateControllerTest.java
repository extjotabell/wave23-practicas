package com.mercadolibre.calculadorametroscuadrados.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateControllerTest {

    @Autowired
    MockMvc mockMvc;

    RoomDTO room, room_2, room_3;
    HouseDTO house;
    ObjectWriter objectWriter = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @BeforeEach
    void setUp(){
        room = new RoomDTO("Living", 30, 10);
        room_2 = new RoomDTO("Habitacion", 3, 5);
        room_3 = new RoomDTO("Cocina", 10, 6);
        house = new HouseDTO("Casa", "1234", List.of(room, room_2, room_3));
    }

    @Test
    @DisplayName("Test Calculate")
    void testCalculate() throws Exception{
        HouseResponseDTO expected = new HouseResponseDTO(house);
        expected.setBiggest(room);
        expected.setPrice(300000);
        expected.setSquareFeet(375);

        MockHttpServletRequestBuilder request = post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectWriter.writeValueAsString(house));

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(objectWriter.writeValueAsString(expected), result.getResponse().getContentAsString());
    }

}
