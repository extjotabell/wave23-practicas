package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.InputBlogDto;
import com.mercadolibre.blog.service.IBlogService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.mercadolibre.blog.util.Factory.blogDto1;
import static com.mercadolibre.blog.util.Factory.blogDto2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BlogControllerTest {

    @Mock
    IBlogService service;

    @InjectMocks
    BlogController controller;

    @Test
    @DisplayName("Test to verify the get of all blogs")
    void testGetBlogs(){
        //Arrange
        List<InputBlogDto> expectedBlogs = Arrays.asList(blogDto1(), blogDto2());
        when(service.searchAllBlogs()).thenReturn(expectedBlogs);

        //Act
        ResponseEntity<?> response = controller.getBlogs();

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedBlogs, response.getBody());
    }

    @Test
    @DisplayName("Test to verify the creation of a blog")
    void testCreateBlogs(){
        //Arrange
        InputBlogDto expectedBlog = blogDto1();
        when(service.addBlog(expectedBlog)).thenReturn(expectedBlog);

        //Act
        ResponseEntity<?> response = controller.createBlog(expectedBlog);

        //Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(expectedBlog, response.getBody());
    }

    @Test
    @DisplayName("Test to verify the get blogs by id")
    void testGetBlogsById(){
        //Arrange
        InputBlogDto expectedBlog = blogDto1();
        when(service.searchIdBlogs((long) expectedBlog.getIdBlog())).thenReturn(expectedBlog);

        //Act
        ResponseEntity<?> response = controller.getBlogById((long) expectedBlog.getIdBlog());

        //Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedBlog, response.getBody());
    }
}
