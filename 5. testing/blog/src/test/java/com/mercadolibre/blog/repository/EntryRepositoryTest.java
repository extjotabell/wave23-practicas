package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.EntryBlog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.blog.utils.UtilsTest.getEntryBlog;
import static com.mercadolibre.blog.utils.UtilsTest.getEntryBlogs;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EntryRepositoryTest {

    @Autowired
    EntryRepositoryImpl entryRepository;

    @Test
    @DisplayName("Should be return all blogs")
    void test1() {
        // Arrange
        List<EntryBlog> expectedEntryBlogs = new ArrayList<>();

        // Act
        List<EntryBlog> responseEntryBlogs = entryRepository.getAll();

        // Assert
        assertEquals(expectedEntryBlogs, responseEntryBlogs);
    }

    @Test
    @DisplayName("Should be save / create a blog")
    void test2() {
        // Arrange
        EntryBlog entryBlog = getEntryBlog();
        Integer expectedSize = 1;

        // Act
        entryRepository.createBlog(entryBlog);

        // Assert
        assertEquals(entryRepository.getBlogById(entryBlog.getId()).getId(), entryBlog.getId());
        assertEquals(entryRepository.getAll().size(), expectedSize);
    }

    @Test
    @DisplayName("Should be find blog by id")
    void test3() {
        // Arrange
        Long blogIdToFind = 1L;
        EntryBlog expectedEntryBlog = getEntryBlog();
        entryRepository.createBlog(expectedEntryBlog);
        entryRepository.createBlog(new EntryBlog(2L, "Otro mas", "Para mas placer", "26-12-2023"));

        // Act
        EntryBlog responseEntryBlog = entryRepository.getBlogById(blogIdToFind);

        // Assert
        assertEquals(expectedEntryBlog, responseEntryBlog);
    }
}
