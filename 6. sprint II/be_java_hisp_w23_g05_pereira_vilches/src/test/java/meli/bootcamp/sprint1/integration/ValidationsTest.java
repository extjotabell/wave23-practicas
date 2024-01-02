package meli.bootcamp.sprint1.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static meli.bootcamp.sprint1.utils.Factory.*;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ValidationsTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test: Endpoint products/post, testing validations")
    void testValidationNewPostDtoNotOk() throws Exception {

        String requestJson = writer().writeValueAsString(generateNewPostDtoWErrors());
        String message = "Se encontraron errores de validación";

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.explanation").value(message))
                .andReturn();
    }

    @Test
    @DisplayName("Test: Endpoint products/post testing validations")
    void testValidationNewPostDto2NotOk() throws Exception {

        String requestJson = writer().writeValueAsString(generateNewPostDtoWErrors2());
        String message = "Se encontraron errores de validación";

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.explanation").value(message))
                .andReturn();
    }

    @Test
    @DisplayName("Test: Endpoint /users/{userId}/followed/list testing validations")
    void testFollowedList() throws Exception {

        String message = "Se encontraron errores de validaciones: ";

        this.mockMvc.perform(get("/users/{userId}/followed/list", 0))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.explanation").value(message))
                .andExpect(jsonPath("$.message", hasItem("El id debe ser mayor a 0.")))
                .andReturn();
    }

    private ObjectWriter writer(){
        return  new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }
}
