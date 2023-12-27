package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.InputBlog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static com.mercadolibre.blog.util.Factory.blog1;
import static com.mercadolibre.blog.util.Factory.blog2;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BlogRepositoryImplTest {

    @Autowired
    IBLogRepository repository;

    @Test
    @DisplayName("Test to verify that the method findAll() returns a list of blogs")
    void testFindAll() {
        // Arrange
        repository.addBlog(blog1());
        repository.addBlog(blog2());

        // Act
        List<InputBlog> blogs = repository.findAll();

        // Assert
        assertTrue(blogs.contains(blog1()), "The list of blogs should contain the first blog");
        assertTrue(blogs.contains(blog2()), "The list of blogs should contain the second blog");
    }

    @Test
    @DisplayName("Test to verify that the method findIdBlog() returns a list with the given id")
    void testFindIdBlog(){
        // Arrange
        repository.addBlog(blog1());
        repository.addBlog(blog2());

        // Act
        List<InputBlog> blogs = repository.findIdBlog(1L);

        // Assert
        assertTrue(blogs.contains(blog1()), "The list of blogs should contain the first blog");
        assertFalse(blogs.contains(blog2()), "The list of blogs should not contain the second blog");
    }
}
