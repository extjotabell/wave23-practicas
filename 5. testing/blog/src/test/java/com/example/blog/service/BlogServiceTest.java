package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.entity.EntryBlog;
import com.example.blog.exception.EntryBlogDuplicateException;
import com.example.blog.exception.EntryBlogListEmptyException;
import com.example.blog.exception.EntryBlogNotFoundException;
import com.example.blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {
    @Mock
    BlogRepository repository;

    @InjectMocks
    BlogService service;

    @Test
    void addEntryBlogOk() {
        //Arrange
        EntryBlog entryBlog = new EntryBlog();
        Long expected = 10L;
        entryBlog.setId(expected);
        when(repository.addEntryBlog(entryBlog)).thenReturn(entryBlog.getId());
        //Act
        Long result = repository.addEntryBlog(entryBlog);
        //Assertion
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Add entry blog when this already exists")
    void addEntryBlogAlreadyExist() {
        //Arrange
        EntryBlog entryBlog = new EntryBlog();
        Long expected = 10L;
        entryBlog.setId(expected);
        when(repository.addEntryBlog(entryBlog)).thenThrow(EntryBlogDuplicateException.class);
        //Act
        assertThrows(EntryBlogDuplicateException.class, () -> service.addEntryBlog(entryBlog));
    }

    @Test
    void getEntryBlogAlreadyExists() {
        //Arrange
        Long id = 10L;
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(id);
        ObjectMapper mapper = new ObjectMapper();
        BlogDTO expected = mapper.convertValue(entryBlog, BlogDTO.class);
        when(repository.getEntryBlogById(id)).thenReturn(entryBlog);
        //Act
        BlogDTO result = service.getEntryBlogById(id);
        //Assertion
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getEntryBlogNotExists() {
        //Arrange
        Long id = 10L;
        when(repository.getEntryBlogById(id)).thenThrow(EntryBlogNotFoundException.class);
        //Act && Assert
        assertThrows(EntryBlogNotFoundException.class, () -> service.getEntryBlogById(id));
    }

    @Test
    void getAllOk() {
        //Arrange
        EntryBlog e1 = new EntryBlog();
        e1.setId(1L);
        EntryBlog e2 = new EntryBlog();
        e2.setId(2L);
        ObjectMapper mapper = new ObjectMapper();
        List<EntryBlog> entries = List.of(e1, e2);
        when(repository.getAllEntryBlog()).thenReturn(entries);
        List<BlogDTO> expected = entries.stream().map(entryBlog -> mapper.convertValue(entryBlog, BlogDTO.class)).toList();
        //Act
        List<BlogDTO> result = service.getAllEntryBlog();
        //Assertion
        Assertions.assertEquals(expected, result);
    }

    @Test
    void getAllEmptyList() {
        //Arrange
        when(repository.getAllEntryBlog()).thenThrow(EntryBlogListEmptyException.class);
        //Act & Assert
        assertThrows(EntryBlogListEmptyException.class, ()-> service.getAllEntryBlog());
    }
}
