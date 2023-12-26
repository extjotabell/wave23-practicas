package com.meli.blogapi.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.blogapi.dto.request.EntryBlogDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BlogControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;

    @Test
    @DisplayName("Save a valid entry blog dto")
    void saveBlogShouldReturnEntryBog() throws Exception{
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(100L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJSON = writer.writeValueAsString(entryBlogDTOTest);
        String responseJSONExpected = writer.writeValueAsString(entryBlogDTOTest);

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/blogs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Save a duplicated entry blog dto")
    void saveDuplicatedBlogShouldReturnException() throws Exception{
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(500L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJSON = writer.writeValueAsString(entryBlogDTOTest);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/blogs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON));
        //Act - Arrange
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/api/v1/blogs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The given id has been previously registered"))
                .andExpect(jsonPath("$.field").value("ID"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Get an entry blog dto by valid id")
    void getBlogByValidIdShouldReturnEntryBog() throws Exception{
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(600L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJSON = writer.writeValueAsString(entryBlogDTOTest);
        String responseJSONExpected = writer.writeValueAsString(entryBlogDTOTest);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/blogs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/blogs/{id}", 600L)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJSONExpected))
                .andExpect(status().isFound());
    }

    @Test
        @DisplayName("Get an entry blog dto by invalid id")
    void getBlogByValidIdShouldReturnException() throws Exception{
        //Arrange
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/blogs/{id}", 67000L)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("There is no blog with the given id "))
                .andExpect(jsonPath("$.field").value("ID"))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Save a entry blog dto by invalid id")
    void getListBlogsShouldReturnList() throws Exception{
        //Arrange
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(600L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJSON = writer.writeValueAsString(entryBlogDTOTest);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/api/v1/blogs")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON));

        //Act - Assert
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api/v1/blogs")
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$", hasSize(greaterThan(0))))
                .andExpect(status().isFound());
    }



}
