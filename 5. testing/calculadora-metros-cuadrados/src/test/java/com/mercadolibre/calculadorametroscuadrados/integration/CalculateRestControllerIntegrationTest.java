package com.mercadolibre.calculadorametroscuadrados.integration;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateRestControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  private static ObjectWriter writer;

  @BeforeAll
  public static void setUp() {
    writer = new ObjectMapper()
        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        .writer().withDefaultPrettyPrinter();

  }

  // a) Se pide, retornar un objeto que diga la cantidad totales de metros
  // cuadrados de la casa.
  @Test
  void calculateWorking() throws Exception {
    HouseDTO houseRequest = new HouseDTO();
    houseRequest.setName("Casa Linda");
    houseRequest.setAddress("Independencia 1234");
    RoomDTO room1 = new RoomDTO();
    room1.setName("Habitacion 1");
    room1.setLength(10);
    room1.setWidth(10);
    RoomDTO room2 = new RoomDTO();
    room2.setName("Banio");
    room2.setLength(7);
    room2.setWidth(6);
    RoomDTO room3 = new RoomDTO();
    room3.setName("Living");
    room3.setLength(15);
    room3.setWidth(10);
    houseRequest.setRooms(List.of(room1, room2, room3));

    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/calculate")
        .contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(houseRequest));

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // // Body
    HouseResponseDTO expectedBody = new HouseResponseDTO(houseRequest);
    expectedBody.setSquareFeet(292);
    expectedBody.setPrice(233600);
    expectedBody.setBiggest(room3);
    ResultMatcher body = MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedBody));

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(body) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }

  // //b) Indicar el valor de la casa tomando en cuenta que se toma como
  // referencia USD 800 el metro cuadrado.
  @Test
  void calculateHousePrice() throws Exception {
    HouseDTO houseRequest = new HouseDTO();
    houseRequest.setName("Casa Linda");
    houseRequest.setAddress("Independencia 1234");
    RoomDTO room1 = new RoomDTO();
    room1.setName("Habitacion 1");
    room1.setLength(10);
    room1.setWidth(10);
    RoomDTO room2 = new RoomDTO();
    room2.setName("Banio");
    room2.setLength(7);
    room2.setWidth(6);
    RoomDTO room3 = new RoomDTO();
    room3.setName("Living");
    room3.setLength(15);
    room3.setWidth(10);
    houseRequest.setRooms(List.of(room1, room2, room3));

    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/calculate")
        .contentType(MediaType.APPLICATION_JSON).content(writer.writeValueAsString(houseRequest));

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body Part
    ResultMatcher bodyPart = MockMvcResultMatchers.jsonPath("$.price").value(233600);

    this.mockMvc.perform(request)
        .andExpect(status)
        .andExpect(contentType)
        .andExpect(bodyPart)
        .andDo(MockMvcResultHandlers.print());
  }

}
