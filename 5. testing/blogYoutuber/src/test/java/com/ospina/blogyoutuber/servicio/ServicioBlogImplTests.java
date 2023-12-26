package com.ospina.blogyoutuber.servicio;

import com.ospina.blogyoutuber.excepcion.EntradaBlogExistenteExcepcion;
import com.ospina.blogyoutuber.excepcion.EntradaBlogNoEncontradaExcepcion;
import com.ospina.blogyoutuber.modelo.comando.ComandoBlog;
import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;
import com.ospina.blogyoutuber.repositorio.RepositorioBlog;
import com.ospina.blogyoutuber.repositorio.RepositorioBlogImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServicioBlogImplTests {

    @Mock
    private RepositorioBlogImpl repositorioBlog;
    @InjectMocks
    private ServicioBlogImpl servicioBlog;

    @Test
    void shouldCreateBlogEntryWhenIdDoesNotExist() {
    // Arrange
    ComandoBlog comandoBlog = new ComandoBlog("Titulo", "Autor", LocalDate.now());
    EntradaBlog entradaBlog = new EntradaBlog(comandoBlog.getTitulo(), comandoBlog.getAutor(), comandoBlog.getFechaPublicacion());
    when(repositorioBlog.existeEntradaBlogPorId(anyInt())).thenReturn(false);
        doNothing().when(repositorioBlog).guardarEntradaBlog(any(EntradaBlog.class));
    // Act
    int id = servicioBlog.crearEntradaBlog(comandoBlog);

    // Assert
    assertEquals(entradaBlog.getId(), id);
    }

    @Test
    void shouldThrowExceptionWhenCreatingBlogEntryWithExistingId() {
        // Arrange
        ComandoBlog comandoBlog = new ComandoBlog("Titulo", "Autor", LocalDate.now());
        when(repositorioBlog.existeEntradaBlogPorId(anyInt())).thenReturn(true);

        // Act & Assert
        assertThrows(EntradaBlogExistenteExcepcion.class, () -> servicioBlog.crearEntradaBlog(comandoBlog));
    }

    @Test
    void shouldReturnBlogEntryWhenIdExists() {
        // Arrange
        EntradaBlog entradaBlog = new EntradaBlog("Titulo", "Autor", LocalDate.now());
        when(repositorioBlog.obtenerEntradaBlogPorId(anyInt())).thenReturn(entradaBlog);

        // Act
        EntradaBlog result = servicioBlog.obtenerEntradaBlogPorId(entradaBlog.getId());

        // Assert
        assertEquals(entradaBlog, result);
    }

    @Test
    void shouldThrowExceptionWhenObtainingBlogEntryWithNonExistingId() {
        // Arrange
        when(repositorioBlog.obtenerEntradaBlogPorId(anyInt())).thenReturn(null);

        // Act & Assert
        assertThrows(EntradaBlogNoEncontradaExcepcion.class, () -> servicioBlog.obtenerEntradaBlogPorId(1));
    }

    @Test
    void shouldReturnAllBlogEntries() {
        // Arrange
        List<EntradaBlog> entradaBlogs = Arrays.asList(
                new EntradaBlog("Titulo1", "Autor1", LocalDate.now()),
                new EntradaBlog("Titulo2", "Autor2", LocalDate.now())
        );
        when(repositorioBlog.obtenerEntradasBlog()).thenReturn(entradaBlogs);

        // Act
        List<EntradaBlog> result = servicioBlog.obtenerEntradasBlog();

        // Assert
        assertEquals(entradaBlogs, result);
    }
}
