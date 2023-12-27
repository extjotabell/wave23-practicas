package com.ejercicio.blog.service;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogsDto;
import com.ejercicio.blog.dto.response.ResponseIdBlogDto;
import com.ejercicio.blog.entity.Blog;
import com.ejercicio.blog.exception.BadRequestException;
import com.ejercicio.blog.exception.NotFoundException;
import com.ejercicio.blog.repository.BlogRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogServiceImplTest {
    @Mock
    BlogRepositoryImpl repository;

    @InjectMocks
    BlogServiceImpl service;

    @Test
    void crearBlogTest() {
        // Arrange
        Blog blog = new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));

        RequestBlogDto blogDto = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));

        ResponseIdBlogDto expected = new ResponseIdBlogDto(0);
        when(repository.getBlogById(blogDto.getId())).thenReturn(null);
        when(repository.crearBlog(any())).thenReturn(blog);

        // Act
        ResponseIdBlogDto actual = service.crearBlog(blogDto);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void crearBlogBadRequestExceptionTest() {
        // Arrange
        Blog blog = new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        repository.crearBlog(blog);

        when(repository.crearBlog(blog)).thenThrow(new BadRequestException("La entrada ya existe"));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> repository.crearBlog(blog));
    }

    @Test
    void getBlogByIdTest() {
        // Arrange
        Blog blog = new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));

        RequestBlogDto blogDto = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        service.crearBlog(blogDto);

        ResponseBlogDto expected = new ResponseBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));

        when(repository.getBlogById(any())).thenReturn(blog);

        // Act
        ResponseBlogDto actual = service.getBlogById(0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getBlogByIdNotFoundExceptionTest() {
        // Arrange
        Integer id = -1;

        when(repository.getBlogById(id)).thenThrow(new NotFoundException("No existen entradas cargadas"));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> service.getBlogById(id));
    }

    @Test
    void getBlogsTest() {
        // Arrange
        RequestBlogDto blog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        service.crearBlog(blog);

        List<ResponseBlogDto> listOfBlogs = new ArrayList<>(List.of(
                new ResponseBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31))));
        ResponseBlogsDto expected = new ResponseBlogsDto(listOfBlogs);

        List<Blog> blogs = new ArrayList<>(List.of(
                new Blog(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31))));

        when(repository.getAllBlogs()).thenReturn(blogs);

        // Act
        ResponseBlogsDto actual = service.getBlogs();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getBlogsNotFoundExceptionTest() {
        // Arrange
        when(repository.getAllBlogs()).thenThrow(new NotFoundException("No existen entradas cargadas"));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> service.getBlogs());
    }
}
