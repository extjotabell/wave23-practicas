package com.example.blog.integral;

import com.example.blog.entity.EntryBlog;
import com.example.blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class BlogControllerIntegralTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    BlogRepository repository;

    @BeforeEach
    void setUp(){
        repository.deleteAll();
    }

    @Test
    void addEntryOk() throws Exception {
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(entryBlog);
        MvcResult result = mockMvc.perform(post("/blog").contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andExpect(status().isOk()).andDo(print()).andReturn();
        Assertions.assertEquals("10", result.getResponse().getContentAsString());
    }

    @Test
    void addEntryNotOk() throws Exception {
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        repository.addEntryBlog(entryBlog);
        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(entryBlog);
        mockMvc.perform(post("/blog").contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andExpect(status().isConflict()).andDo(print()).andExpect(content().string(containsString("10")));
    }

    @Test
    void getEntryOk() throws Exception {
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        repository.addEntryBlog(entryBlog);
        mockMvc.perform(get("/blog/{id}", 10L)).andExpect(status().isOk()).andDo(print()).andExpect(content().string(containsString("10")));
    }

    @Test
    void getEntryNotOk() throws Exception {
        mockMvc.perform(get("/blog/{id}", 10L)).andExpect(status().isNotFound()).andDo(print()).andExpect(content().string(containsString("10")));
    }

    @Test
    void getEntriesOk() throws Exception {
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        repository.addEntryBlog(entryBlog);
        mockMvc.perform(get("/blogs")).andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$[0].id").value(10));
    }

    @Test
    void getEntriesNotOk() throws Exception {
        mockMvc.perform(get("/blogs")).andExpect(status().isNotFound()).andDo(print()).andExpect(content().string(containsString("404")));
    }
}
