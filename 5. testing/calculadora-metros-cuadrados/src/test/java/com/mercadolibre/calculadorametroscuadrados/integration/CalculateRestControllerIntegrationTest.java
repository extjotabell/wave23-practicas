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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Test de integración del controller")
    @Test
    public void calculate() throws Exception {
        List<RoomDTO> roomDTOS = new ArrayList<>();
        roomDTOS.add(new RoomDTO("cocina",10,10));
        HouseDTO houseDTO = new HouseDTO("casa1","av mira mar",roomDTOS);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setPrice(80000);
        expected.setBiggest(new RoomDTO("cocina",10,10));
        expected.setSquareFeet(100);

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();

        String payload = writer.writeValueAsString(houseDTO);


        MvcResult mvcResult =  this.mockMvc.perform(MockMvcRequestBuilders.post("/calculate").
                        contentType(MediaType.APPLICATION_JSON).
                        content(payload)).
                andDo(print()).andExpect(status().isOk())
                .andReturn();

        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());
    }
}
