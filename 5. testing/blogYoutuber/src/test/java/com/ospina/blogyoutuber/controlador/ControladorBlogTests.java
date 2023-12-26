package com.ospina.blogyoutuber.controlador;

import com.ospina.blogyoutuber.modelo.comando.ComandoBlog;
import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;
import com.ospina.blogyoutuber.servicio.ServicioBlog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class ControladorBlogTests {

    @InjectMocks
    private ControladorBlog controladorBlog;

    @Mock
    private ServicioBlog servicioBlog;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearBlog_createsBlogSuccessfully() {
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", "Test Author", LocalDate.now());
        when(servicioBlog.crearEntradaBlog(comandoBlog)).thenReturn(1);

        ResponseEntity<String> response = controladorBlog.crearBlog(comandoBlog);

        assertEquals("Se creo la entrada de blog con exito con el id: 1", response.getBody());
    }

    @Test
    void obtenerBlogPorId_returnsBlogSuccessfully() {
        EntradaBlog entradaBlog = new EntradaBlog("Test Title", "Test Author", LocalDate.now());
        when(servicioBlog.obtenerEntradaBlogPorId(1)).thenReturn(entradaBlog);

        ResponseEntity<?> response = controladorBlog.obtenerBlogPorId(1);

        assertEquals(entradaBlog, response.getBody());
    }

    @Test
    void obtenerEntradasBlog_returnsAllBlogsSuccessfully() {
        EntradaBlog entradaBlog1 = new EntradaBlog("Test Title 1", "Test Author 1", LocalDate.now());
        EntradaBlog entradaBlog2 = new EntradaBlog("Test Title 2", "Test Author 2", LocalDate.now());
        List<EntradaBlog> entradaBlogs = Arrays.asList(entradaBlog1, entradaBlog2);
        when(servicioBlog.obtenerEntradasBlog()).thenReturn(entradaBlogs);

        ResponseEntity<?> response = controladorBlog.obtenerEntradasBlog();

        assertEquals(entradaBlogs, response.getBody());
    }

    @Test
    void crearBlog_callsServiceMethodOnce() {
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", "Test Author", LocalDate.now());
        controladorBlog.crearBlog(comandoBlog);

        verify(servicioBlog, times(1)).crearEntradaBlog(comandoBlog);
    }

    @Test
    void obtenerBlogPorId_callsServiceMethodOnce() {
        controladorBlog.obtenerBlogPorId(1);

        verify(servicioBlog, times(1)).obtenerEntradaBlogPorId(1);
    }

    @Test
    void obtenerEntradasBlog_callsServiceMethodOnce() {
        controladorBlog.obtenerEntradasBlog();

        verify(servicioBlog, times(1)).obtenerEntradasBlog();
    }

    @Test
    void crearBlog_throwsExceptionWhenBlogExists() {
        ComandoBlog comandoBlog = new ComandoBlog("Test Title", "Test Author", LocalDate.now());
        when(servicioBlog.crearEntradaBlog(comandoBlog)).thenThrow(new RuntimeException("Blog already exists"));

        assertThrows(RuntimeException.class, () -> controladorBlog.crearBlog(comandoBlog));
    }

    @Test
    void obtenerBlogPorId_throwsExceptionWhenBlogNotFound() {
        when(servicioBlog.obtenerEntradaBlogPorId(1)).thenThrow(new RuntimeException("Blog not found"));

        assertThrows(RuntimeException.class, () -> controladorBlog.obtenerBlogPorId(1));
    }

    @Test
    void obtenerEntradasBlog_throwsExceptionWhenNoBlogsFound() {
        when(servicioBlog.obtenerEntradasBlog()).thenThrow(new RuntimeException("No blogs found"));

        assertThrows(RuntimeException.class, () -> controladorBlog.obtenerEntradasBlog());
    }
}