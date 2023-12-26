package com.meli.blog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.blog.dto.EntryRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BlogIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("Create a correct entry")
    void createEntry() throws Exception {
        // Arrange
        EntryRequestDto entry = new EntryRequestDto(1, "Title", "Content");

        // Act & Assert
        mockMvc.perform(post("/blog")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(entry)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(entry.getId()));
    }

    @Test
    @DisplayName("Create a correct entry with already used id")
    void createEntryWithAlreadyUsedId() throws Exception {
        // Arrange
        EntryRequestDto entry1 = new EntryRequestDto(1, "Title", "Content");
        EntryRequestDto entry2 = new EntryRequestDto(1, "Title", "Content");

        // Act & Assert
        mockMvc.perform(post("/blog")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(entry1)))
            .andExpect(status().isCreated());


        mockMvc.perform(post("/blog")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(entry2)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Get a correct entry")
    void getEntry() throws Exception {
        // Arrange
        EntryRequestDto entry = new EntryRequestDto(1, "Title", "Content");

        // Act & Assert
        mockMvc.perform(post("/blog")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(entry)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(entry.getId()));

        mockMvc.perform(get("/blog/" + entry.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(entry.getId()));
    }

    @Test
    @DisplayName("Get entry with inexistent id")
    void getEntryWithInexistentId() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/blog/345"))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Get all entries")
    void getAllEntries() throws Exception {
        // Arrange
        EntryRequestDto entry1 = new EntryRequestDto(1, "Title", "Content");
        EntryRequestDto entry2 = new EntryRequestDto(2, "Title", "Content");

        // Act & Assert
        mockMvc.perform(post("/blog")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(entry1)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(entry1.getId()));

        mockMvc.perform(post("/blog")
            .contentType("application/json")
            .content(objectMapper.writeValueAsString(entry2)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(entry2.getId()));

        mockMvc.perform(get("/blogs"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].id").value(entry1.getId()))
            .andExpect(jsonPath("$[1].id").value(entry2.getId()));
    }

    @Test
    @DisplayName("Get all entries with empty list")
    void getAllEntriesWithEmptyList() throws Exception {
        // Act & Assert
        mockMvc.perform(get("/blogs"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isEmpty());
    }
}
