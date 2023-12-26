package com.meli.blogapi.service;

import com.meli.blogapi.dto.request.EntryBlogDTO;
import com.meli.blogapi.entity.EntryBlog;
import com.meli.blogapi.exception.DuplicateIdException;
import com.meli.blogapi.exception.NotFoundException;
import com.meli.blogapi.repository.impl.BlogRepository;
import com.meli.blogapi.service.impl.BlogService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BlogServiceTest {
    @Mock
    BlogRepository blogRepository;

    @InjectMocks
    BlogService blogService;

    @Test
    @DisplayName("Save a valid entry blog dto")
    void saveBlogShouldReturnEntryBog(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(100L, "The Blog Test","The developer",
                                                    LocalDate.of(2023, 12, 26));
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(100L,"The Blog Test", "The developer",
                                                    LocalDate.of(2023, 12, 26).toString());

        when(blogRepository.save(entryBlogTest)).thenReturn(entryBlogTest);
        //Act
        EntryBlogDTO entryBlogDTOResult = blogService.save(entryBlogDTOTest);
        //Assert
        assertEquals(entryBlogDTOTest, entryBlogDTOResult);
    }

    @Test
    @DisplayName("Save a invalid entry blog dto")
    void saveDuplicatedBlogShouldReturnException(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(100L, "The Blog Test","The developer",
                LocalDate.of(2023, 12, 26));
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(100L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());

        when(blogRepository.getAll()).thenReturn(List.of(entryBlogTest));
        //Act - Assert
        assertThrows(DuplicateIdException.class, ()-> blogService.save(entryBlogDTOTest) );
    }

    @Test
    @DisplayName("Get an entry blog dto by existing id ")
    void getBlogByIdShouldReturnEntryBog(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(200L, "The Blog Test","The developer",
                LocalDate.of(2023, 12, 26));
        EntryBlogDTO entryBlogDTOTest = new EntryBlogDTO(200L,"The Blog Test", "The developer",
                LocalDate.of(2023, 12, 26).toString());

        when(blogRepository.findById(200L)).thenReturn(entryBlogTest);
        //Act
        EntryBlogDTO entryBlogDTOResult = blogService.getById(200L);
        //Assert
        assertEquals(entryBlogDTOTest, entryBlogDTOResult);
    }

    @Test
    @DisplayName("Get an entry blog dto by nonexistent id ")
    void getNonExistingBlogShouldReturnException(){
        //Arrange
        when(blogRepository.findById(anyLong())).thenReturn(null);
        //Act - Assert
        assertThrows(NotFoundException.class, ()-> blogService.getById(100L) );
    }

    @Test
    @DisplayName("Get entry blog dto list")
    void getlistOfBlogsShouldReturnList(){
        //Arrange
        EntryBlog entryBlogTest = new EntryBlog(200L, "The Blog Test","The developer",
                LocalDate.of(2023, 12, 26));

        when(blogRepository.getAll()).thenReturn(List.of(entryBlogTest));
        //Act
        List<EntryBlogDTO> entryBlogResult = blogService.getAll();
        // Assert
        assertNotNull(entryBlogResult);
    }
}
