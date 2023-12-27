package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    private RoomDTO roomDTO1;
    private RoomDTO roomDTO2;
    private RoomDTO roomDTO3;
    private HouseDTO houseDTO;

    @BeforeEach
    private void setUp() {
        roomDTO1 = new RoomDTO();
        roomDTO1.setName("Living");
        roomDTO1.setWidth(30);
        roomDTO1.setLength(10);

        roomDTO2 = new RoomDTO();
        roomDTO2.setName("Habitación");
        roomDTO2.setWidth(3);
        roomDTO2.setLength(5);

        roomDTO3 = new RoomDTO();
        roomDTO3.setName("Cocina");
        roomDTO3.setWidth(10);
        roomDTO3.setLength(6);

        houseDTO = new HouseDTO();
        houseDTO.setName("Casa1");
        houseDTO.setAddress("234");
        houseDTO.setRooms(List.of(roomDTO1, roomDTO2, roomDTO3));
    }

    @Test
    void calculateTest() throws Exception {
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = objectWriter.writeValueAsString(houseDTO);

        this.mockMvc.perform(post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
