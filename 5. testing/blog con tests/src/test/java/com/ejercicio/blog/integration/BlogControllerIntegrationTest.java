package com.ejercicio.blog.integration;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogsDto;
import com.ejercicio.blog.dto.response.ResponseErrorDto;
import com.ejercicio.blog.dto.response.ResponseIdBlogDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BlogControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void createBlogIntegrationTest() throws Exception {
        RequestBlogDto blogIn = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        ResponseIdBlogDto blogOut = new ResponseIdBlogDto(0);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();
        /*ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();*/

        String requestJson = writer.writeValueAsString(blogIn);
        String responseJson = writer.writeValueAsString(blogOut);

        this.mockMvc.perform(post("/blog")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

    /*@Test
    void createBlogIntegrationExceptionTest() throws Exception {
        RequestBlogDto blogIn = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        ResponseErrorDto blogOut = new ResponseErrorDto("La entrada ya existe", 400);

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String requestJson = writer.writeValueAsString(blogIn);
        String responseJson = writer.writeValueAsString(blogOut);

        // Agrego entrada
        this.mockMvc.perform(post("/blog")
                .contentType("application/json")
                .content(requestJson));

        this.mockMvc.perform(post("/blog")
                .contentType("application/json")
                .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("La entrada ya existe"));
    }*/

    @Test
    void getBlogByIdIntegrationTest() throws Exception {
        ResponseBlogDto blogOut = new ResponseBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));

        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        String responseJson = writer.writeValueAsString(blogOut);


        // Agrego entrada - descomentar si no corres los test juntos
        /*RequestBlogDto addBlog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        String addBlogString = writer.writeValueAsString(addBlog);
        this.mockMvc.perform(post("/blog")
                .contentType("application/json")
                .content(addBlogString));*/


        this.mockMvc.perform(get("/blog/{id}", 0))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

    @Test
    void getBlogByIdNotFoundExceptionIntegrationTest() throws Exception {
        this.mockMvc.perform(get("/blog/{id}", 25))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("No existe la entrada con el id: 25"));
    }

    @Test
    void getBlogsIntegrationTest() throws Exception {
        // Agrego entrada
        ObjectMapper writer = new ObjectMapper();
        writer.registerModule(new JavaTimeModule());
        writer.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false).writer();

        // Descomentar si no corres los test juntos
        /*RequestBlogDto addBlog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        String addBlogString = writer.writeValueAsString(addBlog);
        this.mockMvc.perform(post("/blog")
                .contentType("application/json")
                .content(addBlogString));*/


        List<ResponseBlogDto> listOfBlogs = new ArrayList<>(List.of(
                new ResponseBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31))));
        ResponseBlogsDto blogOut = new ResponseBlogsDto(listOfBlogs);

        String responseJson = writer.writeValueAsString(blogOut);

        this.mockMvc.perform(get("/blogs"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

}
