package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.request.EntryBlogDTO;
import com.mercadolibre.blog.entity.EntryBlog;
import com.mercadolibre.blog.exception.EntryBlogAlreadyExistsException;
import com.mercadolibre.blog.exception.EntryBlogNotExistsException;
import com.mercadolibre.blog.repository.EntryRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.print.attribute.standard.MediaSize;

import java.util.List;

import static com.mercadolibre.blog.utils.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntryServiceTest {

    @Mock
    EntryRepositoryImpl entryRepository;

    @InjectMocks
    EntryServiceImpl entryService;

    @Test
    @DisplayName("Should be create blog")
    void test1() {
        // Arrange
        EntryBlogDTO expectedEntryBlog = getEntryBlogDto();

        // Act
        when(entryRepository.getBlogById(any())).thenReturn(null);
        EntryBlogDTO responseEntryBlog = entryService.createBlog(expectedEntryBlog);

        // Assert
        assertEquals(expectedEntryBlog, responseEntryBlog);
    }

    @Test
    @DisplayName("Should be not create blog because already exist")
    void test2() {
        // Arrange
        EntryBlogDTO expectedEntryBlog = getEntryBlogDto();

        // Act
        when(entryRepository.getBlogById(any())).thenReturn(getEntryBlog());

        // Assert
        assertThrows(EntryBlogAlreadyExistsException.class, () -> entryService.createBlog(expectedEntryBlog));
    }

    @Test
    @DisplayName("Should be find blog by id")
    void test3() {
        // Arrange
        Long blogIdToFind = 1L;
        EntryBlog expectedEntryBlog = getEntryBlog();

        // Act
        when(entryRepository.getBlogById(blogIdToFind)).thenReturn(expectedEntryBlog);
        EntryBlog responseEntryBlog = entryService.getBlogById(blogIdToFind);

        // Assert
        assertEquals(expectedEntryBlog, responseEntryBlog);
    }

    @Test
    @DisplayName("Should be not find blog by id because not exist")
    void test4() {
        // Arrange
        Long blogIdToFind = 99L;
        EntryBlog expectedEntryBlog = getEntryBlog();

        // Act
        when(entryRepository.getBlogById(blogIdToFind)).thenReturn(null);

        // Assert
        assertThrows(EntryBlogNotExistsException.class, () -> entryService.getBlogById(blogIdToFind));
    }

    @Test
    @DisplayName("Should be get all blogs")
    void test5() {
        // Arrange
        List<EntryBlog> expectedEntryBlogs = getEntryBlogs();

        // Act
        when(entryRepository.getAll()).thenReturn(expectedEntryBlogs);
        List<EntryBlog> responseEntryBlogs = entryService.getAll();

        // Assert
        assertEquals(expectedEntryBlogs, responseEntryBlogs);
    }
}
