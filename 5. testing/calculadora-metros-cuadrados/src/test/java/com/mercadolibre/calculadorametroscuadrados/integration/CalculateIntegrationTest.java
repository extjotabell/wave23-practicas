package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testCalculate() throws Exception{
        HouseResponseDTO payloadDTO = new HouseResponseDTO();
        payloadDTO.setName("Casa");
        payloadDTO.setAddress("Calle Avenida");
        payloadDTO.setRooms(List.of(new RoomDTO("Habitación principal", 5, 8), new RoomDTO("Salon", 2,2)));
        payloadDTO.setSquareFeet(15);
        payloadDTO.setPrice(12000);
        payloadDTO.setBiggest(new RoomDTO("Habitación principal", 5, 8));

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Casa"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address").value("Calle Avenida"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].name").value("Habitación principal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].width").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].length").value(8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[0].squareFeet").value(40))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[1].name").value("Salon"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[1].width").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[1].length").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.rooms[1].squareFeet").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$.squareFeet").value(44))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.name").value("Habitación principal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.width").value(5))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.length").value(8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.biggest.squareFeet").value(40)).andReturn();
    }
}
