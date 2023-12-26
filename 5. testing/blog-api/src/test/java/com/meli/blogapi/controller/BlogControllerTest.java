package com.meli.blogapi.controller;

import com.meli.blogapi.dto.request.EntryBlogDTO;
import com.meli.blogapi.service.impl.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogControllerTest {

    @Mock
    BlogService blogService;

    @InjectMocks
    BlogCrontoller blogCrontoller;

    @Test
    @DisplayName("Save a valid entry blog dto")
    void saveBlogShouldReturnEntryBog(){
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(100L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());

        when(blogService.save(entryBlogDTOTest)).thenReturn(entryBlogDTOTest);
        //Act
        ResponseEntity<EntryBlogDTO> entryBlogDTOResult = blogCrontoller.saveNewBlog(entryBlogDTOTest);
        //Assert
        assertEquals(HttpStatus.CREATED, entryBlogDTOResult.getStatusCode());
        assertEquals(entryBlogDTOTest, entryBlogDTOResult.getBody());
    }

    @Test
    @DisplayName("Get an entry blog dto by existing id ")
    void getBlogByIdShouldReturnEntryBog(){
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(200L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());

        when(blogService.getById(200L)).thenReturn(entryBlogDTOTest);
        //Act
        ResponseEntity<EntryBlogDTO> entryBlogDTOResult = blogCrontoller.getById(200L);
        //Assert
        assertEquals(HttpStatus.FOUND, entryBlogDTOResult.getStatusCode());
        assertEquals(entryBlogDTOTest, entryBlogDTOResult.getBody());
    }

    @Test
    @DisplayName("Get entry blog dto list")
    void getlistOfBlogsShouldReturnList(){
        //Arrange
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(200L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());

        when(blogService.getAll()).thenReturn(List.of(entryBlogDTOTest));
        //Act
        ResponseEntity<List<EntryBlogDTO>> entryBlogDTOResult = blogCrontoller.getAll();
        // Assert
        assertEquals(HttpStatus.FOUND, entryBlogDTOResult.getStatusCode());
        assertEquals(List.of(entryBlogDTOTest), entryBlogDTOResult.getBody());
    }
}
