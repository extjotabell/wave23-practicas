package com.ospina.blogyoutuber.repositorio;

import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositorioBlogImplTests {
    private RepositorioBlogImpl repositorioBlog;
    private EntradaBlog entradaBlog;

    @BeforeEach
    void setUp() {
        repositorioBlog = new RepositorioBlogImpl();
        entradaBlog = new EntradaBlog("Test Title", "Test Author", LocalDate.now());
    }

    @Test
    void shouldSaveBlogEntry() {
        repositorioBlog.guardarEntradaBlog(entradaBlog);
        EntradaBlog retrievedBlog = repositorioBlog.obtenerEntradaBlogPorId(entradaBlog.getId());
        assertEquals(entradaBlog, retrievedBlog);
    }

    @Test
    void shouldReturnNullWhenBlogEntryNotFound() {
        EntradaBlog retrievedBlog = repositorioBlog.obtenerEntradaBlogPorId(999);
        assertNull(retrievedBlog);
    }

    @Test
    void shouldReturnAllBlogEntries() {
        repositorioBlog.guardarEntradaBlog(entradaBlog);
        List<EntradaBlog> blogEntries = repositorioBlog.obtenerEntradasBlog();
        assertTrue(blogEntries.contains(entradaBlog));
    }

    @Test
    void shouldReturnTrueWhenBlogEntryExists() {
        repositorioBlog.guardarEntradaBlog(entradaBlog);
        boolean exists = repositorioBlog.existeEntradaBlogPorId(entradaBlog.getId());
        assertTrue(exists);
    }

    @Test
    void shouldReturnFalseWhenBlogEntryDoesNotExist() {
        boolean exists = repositorioBlog.existeEntradaBlogPorId(999);
        assertFalse(exists);
    }
}