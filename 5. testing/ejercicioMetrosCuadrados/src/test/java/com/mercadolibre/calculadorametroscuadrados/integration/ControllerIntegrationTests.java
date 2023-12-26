package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    public ControllerIntegrationTests(){
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("Calculate test with valid payload")
    void calculateTest() throws Exception{
        HouseDTO payload = new HouseDTO(
                "Nombre generico",
                "Dirección generica",
                List.of(
                        new RoomDTO("Living", 5, 7),
                        new RoomDTO("Cocina", 5, 2),
                        new RoomDTO("Cuarto", 4, 4)
                )
        );
        MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(payload));

        HouseResponseDTO expectedResult = new HouseResponseDTO(
                payload,
                61,
                48800,
                new RoomDTO("Living", 5, 7)
        );
        System.out.println("Expected: " + writer.writeValueAsString(expectedResult));
        ResultMatcher expectedStatus = MockMvcResultMatchers.status().isOk();
        ResultMatcher expectedContentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher expectedContent = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResult));


        mockMvc.perform(req)
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedContentType)
                .andExpect(expectedContent);
    }
}
