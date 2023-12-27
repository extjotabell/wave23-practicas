package com.mercadolibre.blog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.service.IEntryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static com.mercadolibre.blog.utils.UtilsTest.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EntryBlogControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IEntryService entryService;

    @Test
    @DisplayName("Should be create blog ok")
    void test1() throws Exception {
        // Arrange
        EntryBlog requestEntryBlog = getEntryBlog();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(requestEntryBlog);

        // Act
        this.mockMvc.perform(post("/api/entryBlog/create")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Should be not create blog because already exists")
    void test2() throws Exception {
        // Arrange
        EntryBlog requestEntryBlog = getEntryBlog();

        EntryBlogDTO entryBlogDTO = getEntryBlogDto();
        entryService.createBlog(entryBlogDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(requestEntryBlog);

        // Act
        this.mockMvc.perform(post("/api/entryBlog/create")
                        .contentType("application/json")
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(jsonPath("$").value("El blog con ese id ya existe"));
    }

    @Test
    @DisplayName("Should be get blog by id")
    void test3() throws Exception {
        // Arrange
        Long blogIdToFind = 1L;
        EntryBlog expectedReturn = getEntryBlog();

        EntryBlogDTO blogToAdd = getEntryBlogDto();
        entryService.createBlog(blogToAdd);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(expectedReturn);

        // Act
        this.mockMvc.perform(get("/api/entryBlog/getBlog/{id}", blogIdToFind))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(payloadJson));
    }

    @Test
    @DisplayName("Should be no get inexists id")
    void test4() throws Exception {
        // Arrange
        Long blogIdToFind = 1L;

        // Act
        this.mockMvc.perform(get("/api/entryBlog/getBlog/{id}", blogIdToFind))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(jsonPath("$").value("El blog solicitado no existe"));
    }

    @Test
    @DisplayName("Should be get all blogs")
    void test5() throws Exception {
        // Arrange
        List<EntryBlog> expectedReturn = getEntryBlogs();

        EntryBlogDTO entryBlogDTO1 = new EntryBlogDTO(1L, "Harry Potter", "El prisionero de azkaban", "08-07-1999");
        EntryBlogDTO entryBlogDTO2 = new EntryBlogDTO(2L, "Harry Potter", "La piedra filosofal", "26-06-1997");
        entryService.createBlog(entryBlogDTO1);
        entryService.createBlog(entryBlogDTO2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        String payloadJson = writer.writeValueAsString(expectedReturn);

        //Act
        this.mockMvc.perform(get("/api/entryBlog/getAll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(payloadJson));

        // Assert

    }
}
