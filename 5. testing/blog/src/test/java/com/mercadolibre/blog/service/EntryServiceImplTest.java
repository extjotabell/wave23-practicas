package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.exception.EntryBlogAlreadyExistsException;
import com.mercadolibre.blog.exception.EntryBlogNotExistsException;
import com.mercadolibre.blog.repository.EntryRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntryServiceImplTest {

    @Mock
    EntryRepositoryImpl repository;

    @InjectMocks
    EntryServiceImpl service;

    private static final String DATE_FORMAT = "2022-12-10";

    @Test
    @DisplayName("Create new blog.")
    void createBlogTest() {
        // ARRANGE
        when(repository.getBlogById(1L)).thenReturn(null);

        EntryBlogDTO expected = createEntryBlogDTO(1L, "New Blog", "Title", DATE_FORMAT);

        // ACT
        EntryBlogDTO result = service.createBlog(expected);

        // ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Create new blog. Exception.")
    void createBlogExceptionTest() {
        // ARRANGE
        EntryBlogDTO entryBlogDTO = createEntryBlogDTO(1L, "New Blog", "Title", DATE_FORMAT);
        EntryBlog entryBlogExisting = createEntryBlog(entryBlogDTO);

        when(repository.getBlogById(entryBlogDTO.getId())).thenReturn(entryBlogExisting);

        // ACT & ASSERT
        assertThrows(EntryBlogAlreadyExistsException.class, () -> service.createBlog(entryBlogDTO));

        // Verify that the getBlogById method was called
        verify(repository).getBlogById(entryBlogDTO.getId());
    }

    @Test
    @DisplayName("Get blog by ID")
    void getBlogByIdTest() {
        // ARRANGE
        EntryBlogDTO expected = createEntryBlogDTO(1L, "New Blog", "Title", DATE_FORMAT);
        EntryBlog entryBlog = createEntryBlog(expected);

        when(repository.getBlogById(expected.getId())).thenReturn(entryBlog);

        // ACT
        EntryBlogDTO result = service.getBlogById(1L);

        // ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Get blog by ID. Exception.")
    void getBlogByIdExceptionTest() {
        // ARRANGE
        Long id = 1L;

        // ACT & ASSERT
        assertThrows(EntryBlogNotExistsException.class, () -> service.getBlogById(id));
    }

    private EntryBlogDTO createEntryBlogDTO(Long id, String name, String title, String date) {
        EntryBlogDTO entryBlogDTO = new EntryBlogDTO();
        entryBlogDTO.setId(id);
        entryBlogDTO.setName(name);
        entryBlogDTO.setTitle(title);
        entryBlogDTO.setDate(date);
        return entryBlogDTO;
    }

    private EntryBlog createEntryBlog(EntryBlogDTO entryBlogDTO) {
        EntryBlog entryBlog = new EntryBlog();
        entryBlog.setId(entryBlogDTO.getId());
        entryBlog.setName(entryBlogDTO.getName());
        entryBlog.setTitle(entryBlogDTO.getTitle());
        entryBlog.setDate(entryBlogDTO.getDate());
        return entryBlog;
    }
}
