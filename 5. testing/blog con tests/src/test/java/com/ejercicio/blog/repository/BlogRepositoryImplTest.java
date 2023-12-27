package com.ejercicio.blog.repository;

import com.ejercicio.blog.entity.Blog;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlogRepositoryImplTest {

    private BlogRepositoryImpl repository = new BlogRepositoryImpl();

    @Test
    void createBlogTest() {
        // Arrange
        Blog blog = new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        Blog expected = repository.crearBlog(blog);

        // Act
        Blog actual = repository.crearBlog(blog);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getBlogByIdTest() {
        // Arrange
        Blog blog = new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        Blog expected = repository.crearBlog(blog);

        // Act
        Blog actual = repository.getBlogById(blog.getId());

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getAllBlogsTest() {
        // Arrange
        Blog blog1 = new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        Blog blog2 = new Blog(1, "Blog de prueba2", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        repository.crearBlog(blog1);
        repository.crearBlog(blog2);
        List<Blog> expected = new ArrayList<>(List.of(blog1, blog2));

        // Act
        List<Blog> actual = repository.getAllBlogs();

        // Assert
        assertEquals(expected, actual);
    }

}
