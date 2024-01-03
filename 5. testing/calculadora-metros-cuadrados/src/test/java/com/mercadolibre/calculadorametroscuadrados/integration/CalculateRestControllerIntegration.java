package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.mercadolibre.calculadorametroscuadrados.util.FactoryOfObject.houseDto;
import static com.mercadolibre.calculadorametroscuadrados.util.FactoryOfObject.roomDto1;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    private HouseDTO houseDTO;

    @BeforeEach
    public void setup() {
        houseDTO = houseDto();
    }

    @Test
    @DisplayName("calculate integration test")
    public void calculateTest() throws Exception {

        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);

        expected.setBiggest(roomDto1());
        expected.setSquareFeet(375);
        expected.setPrice(300000);

        String payloadJson = objectWriter.writeValueAsString(houseDTO);
        String responseJson = objectWriter.writeValueAsString(expected);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson))
                .andReturn();
    }
}
