package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.util.HouseDTOTestGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerTestIntegration {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET ENDPOINT: House with rooms - obtain the calculated values")
    void calculateDataHouseDTOShouldReturnValidData() throws Exception {
        //Arrange
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithRooms();

        String payloadJSON = writer.writeValueAsString(houseDTOTest);
        String responseJSONExpected =writer.writeValueAsString(houseResponseDTO);

        //Act - Assert
        this.mockMvc.perform(
                            MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("GET ENDPOINT: House without rooms - obtain the calculated values")
    void calculateDataHouseDTOWithoutRoomsShouldReturnValidData() throws Exception {
        //Arrange
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        HouseDTO houseDTOTest = HouseDTOTestGenerator.getHouseDTOWithoutRooms();
        HouseResponseDTO houseResponseDTO = HouseDTOTestGenerator.getHouseResponseDTOWithoutRooms();

        String payloadJSON = writer.writeValueAsString(houseDTOTest);
        String responseJSONExpected =writer.writeValueAsString(houseResponseDTO);

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/calculate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isOk());
    }

}
