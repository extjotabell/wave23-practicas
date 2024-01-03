package com.mercadolibre.be_java_hisp_w23_g2.integration;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.requests.PostDTO;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {

  @Autowired
  MockMvc mockMvc;

  @Test
  @DirtiesContext
  void addPost() throws Exception {
    PostDTO postDTO = new PostDTO(1, LocalDate.now(),
        new ProductBasicDTO(1, "Guitarra", "Instrumento", "Gibson", "Negro",
            "Guitarra profesional"), 9, 600.0);
    ObjectWriter writer = new ObjectMapper().writer();

    String payloadJson = writer.writeValueAsString(postDTO);

    mockMvc.perform(
            post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson))
        .andDo(print()).andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(jsonPath("$.message").value("Publication successfully added."));
  }

}
