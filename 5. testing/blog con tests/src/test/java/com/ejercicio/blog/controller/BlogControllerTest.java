package com.ejercicio.blog.controller;

import com.ejercicio.blog.dto.request.RequestBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogDto;
import com.ejercicio.blog.dto.response.ResponseBlogsDto;
import com.ejercicio.blog.dto.response.ResponseIdBlogDto;
import com.ejercicio.blog.exception.BadRequestException;
import com.ejercicio.blog.exception.NotFoundException;
import com.ejercicio.blog.service.BlogServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BlogControllerTest {
    @Mock
    BlogServiceImpl service;

    @InjectMocks
    BlogController controller;

    @Test
    void createBlogTest() {
        // Arrange
        RequestBlogDto blog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        ResponseIdBlogDto expected = new ResponseIdBlogDto(blog.getId());
        ResponseIdBlogDto actual = new ResponseIdBlogDto(0);
        ResponseEntity<?> expectedResponseEntity = new ResponseEntity<>(expected, HttpStatus.OK);

        when(service.crearBlog(blog)).thenReturn(actual);

        // Act
        ResponseEntity<?> actualResponseEntity = controller.crearBlog(blog);

        // Assert
        assertEquals(expectedResponseEntity.getBody(), actualResponseEntity.getBody());
    }

    @Test
    void createBlogAlreadyExistTest() {
        // Arrange
        RequestBlogDto blog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        controller.crearBlog(blog);
        when(service.crearBlog(blog)).thenThrow(new BadRequestException("La entrada ya existe"));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> controller.crearBlog(blog));
    }

    @Test
    void createBlogNullTest() {
        // Arrange
        RequestBlogDto blog = null;
        controller.crearBlog(blog);
        when(service.crearBlog(blog)).thenThrow(new BadRequestException("Error al crear entrada"));

        // Act & Assert
        assertThrows(BadRequestException.class, () -> controller.crearBlog(blog));
    }

    @Test
    void getBlogByIdTest() {
        // Arrange
        RequestBlogDto blog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        controller.crearBlog(blog);

        ResponseBlogDto expectedDto = new ResponseBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        ResponseEntity<?> expected = new ResponseEntity<>(expectedDto, HttpStatus.OK);

        ResponseIdBlogDto responseId = new ResponseIdBlogDto(0);
        when(service.getBlogById(responseId.getId())).thenReturn(expectedDto);

        // Act
        ResponseEntity<?> actual = controller.getBlogById(0);

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getBlogByIdNotFoundTest() {
        // Arrange
        Integer id = 1;
        when(service.getBlogById(id)).thenThrow(new NotFoundException("No existe la entrada con el id: " + id));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> controller.getBlogById(id));
    }

    @Test
    void getBlogsTest() {
        // Arrange
        RequestBlogDto blog = new RequestBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31));
        controller.crearBlog(blog);

        List<ResponseBlogDto> listOfBlogs = new ArrayList<>(List.of(
                new ResponseBlogDto(0, "Blog de prueba", "Marcos Costanzo", LocalDate.of(1998, 1, 31))));
        ResponseBlogsDto expectedDto = new ResponseBlogsDto(listOfBlogs);
        ResponseEntity<?> expected = new ResponseEntity<>(expectedDto, HttpStatus.OK);

        when(service.getBlogs()).thenReturn(expectedDto);

        // Act
        ResponseEntity<?> actual = controller.getBlogs();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    void getBlogsNotFoundTest() {
        // Arrange
        when(service.getBlogs()).thenThrow(new NotFoundException("No existen entradas cargadas"));

        // Act & Assert
        assertThrows(NotFoundException.class, () -> controller.getBlogs());
    }

}
