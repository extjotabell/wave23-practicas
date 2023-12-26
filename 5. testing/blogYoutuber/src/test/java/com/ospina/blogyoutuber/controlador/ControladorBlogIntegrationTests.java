package com.ospina.blogyoutuber.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ospina.blogyoutuber.modelo.comando.ComandoBlog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ControladorBlogIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void shouldCreateBlogEntry() throws Exception {
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", "Test Author", LocalDate.now());
        String jsonRequest = objectMapper.writeValueAsString(comandoBlog);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/blog")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void shouldNotCreateBlogEntryWithFirstMissingField() throws Exception {
        ComandoBlog comandoBlog = new ComandoBlog(null, "Test Author", LocalDate.now());
        String jsonRequest = objectMapper.writeValueAsString(comandoBlog);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/blog")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldNotCreateBlogEntryWithSecondMissingField() throws Exception {
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", null, LocalDate.now());
        String jsonRequest = objectMapper.writeValueAsString(comandoBlog);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/blog")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldNotCreateBlogEntryWithThirdMissingField() throws Exception {
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", "Test Author", null);
        String jsonRequest = objectMapper.writeValueAsString(comandoBlog);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/blog")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldGetBlogEntryById() throws Exception {
        // Create a blog entry
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", "Test Author", LocalDate.now());
        String jsonRequest = objectMapper.writeValueAsString(comandoBlog);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/blog")
                        .content(jsonRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        // Extract the created blog entry's id
        String responseContent = result.getResponse().getContentAsString();
        //Obtener el numero que está despues del : hasta el final de la cadena de respuesta y convertilo en entero
        int id = Integer.parseInt(responseContent.substring(responseContent.indexOf(":") + 2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/blog/" + id))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotGetBlogEntryByNonexistentId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/blog/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldGetAllBlogEntries() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/blog/obtenerEntradas"))
                .andExpect(status().isOk());
    }
}
