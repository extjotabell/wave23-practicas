package com.mercadolibre.calculadorametroscuadrados.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculateRestControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper writer = new ObjectMapper();

    @Test
    @DisplayName("Calculate endpoint: Multiple rooms ok")
    void calculateMultipleRoomsOk() throws Exception{
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House test name");
        houseDTO.setAddress("Test address");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1DTO = new RoomDTO();
        room1DTO.setName("Room 1 test name");
        room1DTO.setWidth(7);
        room1DTO.setLength(7);
        roomDTOList.add(room1DTO);

        RoomDTO room2DTO = new RoomDTO();
        room2DTO.setName("Room 2 test name");
        room2DTO.setWidth(5);
        room2DTO.setLength(5);
        roomDTOList.add(room2DTO);

        RoomDTO room3DTO = new RoomDTO();
        room3DTO.setName("Room 3 test name");
        room3DTO.setWidth(4);
        room3DTO.setLength(4);
        roomDTOList.add(room3DTO);

        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(90);
        expected.setBiggest(room1DTO);
        expected.setPrice(72000);


        //Preparing request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(houseDTO));

        //Preparing expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        //Act and assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Calculate endpoint: Single rooms ok")
    void calculateSingleRoom() throws Exception{
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House test name");
        houseDTO.setAddress("Test address");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        RoomDTO room1DTO = new RoomDTO();
        room1DTO.setName("Room 1 test name");
        room1DTO.setWidth(9);
        room1DTO.setLength(4);
        roomDTOList.add(room1DTO);

        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(36);
        expected.setBiggest(room1DTO);
        expected.setPrice(28800);

        //Preparing request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(houseDTO));

        //Preparing expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        //Act and Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("Calculate endpoint: No rooms ok")
    void calculateNoRooms() throws Exception{
        //Arrange
        HouseDTO houseDTO = new HouseDTO();
        houseDTO.setName("House test name");
        houseDTO.setAddress("Test address");

        List<RoomDTO> roomDTOList = new ArrayList<>();
        houseDTO.setRooms(roomDTOList);

        HouseResponseDTO expected = new HouseResponseDTO(houseDTO);
        expected.setSquareFeet(0);
        expected.setBiggest(null);
        expected.setPrice(0);

        //Preparing request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(houseDTO));

        //Preparing expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        //Act and Assert
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

}
