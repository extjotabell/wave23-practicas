package com.sprint.be_java_hisp_w23_g04.integration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import com.sprint.be_java_hisp_w23_g04.utils.IntegrationUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductsMeliControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    static void initialize() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .findAndRegisterModules()
                .writer();
    }

    /* Tests for savePost() */

    @Test
    @DisplayName("SavePost successful integration test")
    void testSavePostOk() throws Exception {
        PostDTO postDTO = IntegrationUtils.getPostDTO();
        SimpleMessageDTO simpleMessageDTO = new SimpleMessageDTO("El post para el user: " + postDTO.getUserId() + " se guardó exitosamente");

        String payloadJson = writer.writeValueAsString(postDTO);
        String expectedResult = writer.writeValueAsString(simpleMessageDTO);

        MvcResult result = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("SavePost fails because UserId not exist and throw a NotFoundException")
    void testSavePostButUserIdNotExist() throws Exception {
        PostDTO postDTO = IntegrationUtils.getPostDTO();
        postDTO.setUserId(99); // Set invalid user id
        SimpleMessageDTO expectedException = new SimpleMessageDTO("No se encontró usuario con el id " + postDTO.getUserId() + ".");

        String payloadJson = writer.writeValueAsString(postDTO);
        String expectedResult = writer.writeValueAsString(expectedException);

        MvcResult result = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("SavePost fails because the userId in the PostDTO is null")
    void testSavePostButIsNotValid() throws Exception {
        PostDTO postDTO = IntegrationUtils.getPostDTO();
        postDTO.setUserId(null);

        SimpleMessageDTO expectedException = new SimpleMessageDTO(
                "Se encontraron los siguientes errores en las validaciones:",
                List.of("El id del usuario no puede estar vacío")
        );

        String payloadJson = writer.writeValueAsString(postDTO);
        String expectedResult = writer.writeValueAsString(expectedException);

        MvcResult result = this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson)).andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedResult, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}