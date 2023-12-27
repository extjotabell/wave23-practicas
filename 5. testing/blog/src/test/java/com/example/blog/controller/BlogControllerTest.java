package com.example.blog.controller;

import com.example.blog.dto.BlogDTO;
import com.example.blog.entity.EntryBlog;
import com.example.blog.service.IBlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class BlogControllerTest {

    @Mock
    IBlogService service;

    @InjectMocks
    BlogController controller;


    @Test
    void addEntryOk() {
        //Arrange
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        ResponseEntity<?> expected = ResponseEntity.ok(entryBlog.getId());

        when(service.addEntryBlog(entryBlog)).thenReturn(10L);
        //Act
        ResponseEntity<?> result = controller.addEntryBlog(entryBlog);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getEntryById(){
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        ObjectMapper mapper = new ObjectMapper();
        BlogDTO blogDTO = mapper.convertValue(entryBlog, BlogDTO.class);
        ResponseEntity<?> expected = ResponseEntity.ok(blogDTO);

        when(service.getEntryBlogById(10L)).thenReturn(blogDTO);
        //Act
        ResponseEntity<?> result = controller.getEntryBlogById(10L);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    void getEntries(){
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(10L);
        ObjectMapper mapper = new ObjectMapper();
        BlogDTO blogDTO = mapper.convertValue(entryBlog, BlogDTO.class);
        List<BlogDTO> entries = List.of(blogDTO);
        ResponseEntity<?> expected = ResponseEntity.ok(entries);

        when(service.getAllEntryBlog()).thenReturn(entries);
        //Act
        ResponseEntity<?> result = controller.getEntriesBlog();
        //Assert
        assertEquals(expected, result);
    }
    //Arrange

    //Act

    //Assert
}
