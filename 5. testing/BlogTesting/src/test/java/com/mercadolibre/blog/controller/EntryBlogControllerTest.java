package com.mercadolibre.blog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.util.ObjectFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EntryBlogControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void writer(){
        writer =  new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    void getBlogByIdTest() throws Exception {
        Long param = 1L;

        EntryBlog payload = ObjectFactory.createBlog();

        String payloadExpected = writer.writeValueAsString(payload);

        this.mockMvc.perform(get("/api/entryBlog/getBlog/{id}", param))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(payloadExpected));
    }

    @Test
    void getBlogByIdExceptionTest() throws Exception {
        Long param = 2L;

        this.mockMvc.perform(get("/api/entryBlog/getBlog/{id}", param))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("El blog solicitado no existe"));
    }

    @Test
    void getAllBlogsTest() throws Exception {
        List<EntryBlog> payload = ObjectFactory.createListBlogs();

        String payloadExpected = writer.writeValueAsString(payload);

        this.mockMvc.perform(get("/api/entryBlog/getAll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(payloadExpected));
    }

    @Test
    void createBlogTest() throws Exception {
        EntryBlogDTO payload = ObjectFactory.createEntryBlogDTO();

        String payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(post("/api/entryBlog/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(payloadJson));
    }

    @Test
    void createBlogExceptionTest() throws Exception {
        EntryBlogDTO payload = ObjectFactory.createEntryBlogSameDTO();

        String payloadJson = writer.writeValueAsString(payload);

        this.mockMvc.perform(post("/api/entryBlog/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isConflict())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("El blog con ese id ya existe"));
    }

}
