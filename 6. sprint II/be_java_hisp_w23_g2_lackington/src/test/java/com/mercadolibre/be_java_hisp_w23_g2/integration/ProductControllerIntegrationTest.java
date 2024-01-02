package com.mercadolibre.be_java_hisp_w23_g2.service.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
    ObjectWriter writer = new ObjectMapper().
            configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    @Autowired
    MockMvc mockMvc;

    @DisplayName("Add post integration test")
    @Test
    public void addPost() throws Exception {
        MessageDTO expected = new MessageDTO("Publication successfully added.");

        PostBasicDTO payload = new PostBasicDTO(1,999, LocalDate.now(),new ProductBasicDTO(
                1234,"Album de trap","Musica","Trap Capos","Azul","Top Hits"
        ),"Musica",10000);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").
                        contentType(MediaType.APPLICATION_JSON).
                        content(writer.writeValueAsString(payload))).
                andDo(print()).andExpect(status().isOk())
                .andReturn();
        
        assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());
    }
}
