package com.mercadolibre.starwars.integration;

import java.util.ArrayList;
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
import com.mercadolibre.starwars.dto.CharacterDTO;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
  @Autowired
  MockMvc mockMvc;

  private static ObjectWriter writer;

  @BeforeAll
  public static void setUp() {
    writer = new ObjectMapper()
        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
        .writer().withDefaultPrettyPrinter();

  }

  @Test
  void getAllLikeLuke() throws Exception {
    // Arrange
    String query = "Luke";

    List<CharacterDTO> charactersLikeLuke = new ArrayList<CharacterDTO>();
    CharacterDTO luke = new CharacterDTO();
    luke.setName("Luke Skywalker");
    luke.setHeight(172);
    luke.setMass(77);
    luke.setHair_color("blond");
    luke.setSkin_color("fair");
    luke.setEye_color("blue");
    luke.setBirth_year("19BBY");
    luke.setGender("male");
    luke.setHomeworld("Tatooine");
    luke.setSpecies("Human");
    charactersLikeLuke.add(luke);

    // Request
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}", query);

    // Status
    ResultMatcher status = MockMvcResultMatchers.status().isOk();

    // Content Type
    ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

    // Body
    ResultMatcher body = MockMvcResultMatchers.content().json(writer.writeValueAsString(charactersLikeLuke));

    mockMvc.perform(request) // request
        .andExpect(status) // expected status
        .andExpect(contentType) // expected contentType
        .andExpect(body) // expected body
        .andDo(MockMvcResultHandlers.print()); // print req and resp
  }
}