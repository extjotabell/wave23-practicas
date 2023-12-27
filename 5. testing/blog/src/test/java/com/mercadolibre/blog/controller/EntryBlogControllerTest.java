package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.service.EntryServiceImpl;
import com.mercadolibre.blog.service.IEntryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.mercadolibre.blog.utils.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EntryBlogControllerTest {

    @Mock
    EntryServiceImpl entryService;

    @InjectMocks
    EntryBlogController entryBlogController;

    @Test
    @DisplayName("Should be create a blog")
    void test1() {
        // Arrange
        EntryBlogDTO requestEntryBlog = getEntryBlogDto();
        ResponseEntity<?> expectedRespose = new ResponseEntity<>(requestEntryBlog, HttpStatus.OK);

        // Act
        when(entryService.createBlog(any())).thenReturn(requestEntryBlog);
        ResponseEntity<?> responseEntryBlogDto = entryBlogController.createBlog(requestEntryBlog);

        // Assert
        assertEquals(expectedRespose, responseEntryBlogDto);
    }

    @Test
    @DisplayName("Should be find glob by id")
    void test2() {
        // Arrange
        Long blogIdToFind = 1L;
        EntryBlog requestEntryBlog = getEntryBlog();
        ResponseEntity<?> expectedRespose = new ResponseEntity<>(requestEntryBlog, HttpStatus.OK);

        // Act
        when(entryService.getBlogById(blogIdToFind)).thenReturn(requestEntryBlog);
        ResponseEntity<?> responseEntryBlog = entryBlogController.getBlogById(blogIdToFind);

        // Assert
        assertEquals(expectedRespose, responseEntryBlog);
    }

    @Test
    @DisplayName("Should be return all blogs")
    void test3() {
        // Arrange
        List<EntryBlog> expectedEntryBlogs = getEntryBlogs();
        ResponseEntity<?> expectedRespose = new ResponseEntity<>(expectedEntryBlogs, HttpStatus.OK);

        // Act
        when(entryService.getAll()).thenReturn(expectedEntryBlogs);
        ResponseEntity<?> responeEntryBlogs = entryBlogController.getAll();

        // Assert
        assertEquals(expectedRespose, responeEntryBlogs);
    }
}
