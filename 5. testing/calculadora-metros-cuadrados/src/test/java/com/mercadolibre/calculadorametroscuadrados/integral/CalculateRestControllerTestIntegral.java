package com.mercadolibre.calculadorametroscuadrados.integral;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
public class CalculateRestControllerTestIntegral {

  @Autowired
  MockMvc mockMvc;

  @Test
  void calculateHouseOneRoomOk() throws Exception {
    HouseDTO houseDTO = new HouseDTO();
    RoomDTO bigRoom = new RoomDTO();
    RoomDTO smallRoom = new RoomDTO();
    bigRoom.setWidth(30);
    bigRoom.setLength(40);
    bigRoom.setName("Big room");
    smallRoom.setWidth(20);
    smallRoom.setLength(30);
    houseDTO.setRooms(List.of(smallRoom, bigRoom));

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        .writer();

    String payloadJson = writer.writeValueAsString(houseDTO);
    mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
        .andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.squareFeet").value(1800))
        .andExpect(jsonPath("$.biggest.name").value("Big room")).andExpect(jsonPath("$.price").value(1440000));
  }

  @Test
  void calculateHouseTwoRoomsOk() throws Exception {
    HouseDTO houseDTO = new HouseDTO();
    RoomDTO room = new RoomDTO();
    room.setWidth(30);
    room.setLength(40);
    room.setName("room");

    houseDTO.setRooms(List.of(room));

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        .writer();

    String payloadJson = writer.writeValueAsString(houseDTO);
    mockMvc.perform(post("/calculate").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
        .andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.squareFeet").value(1200))
        .andExpect(jsonPath("$.biggest.name").value("room")).andExpect(jsonPath("$.price").value(960000));
  }
}
