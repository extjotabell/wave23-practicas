package com.ospina.blogyoutuber.modelo;

import com.ospina.blogyoutuber.modelo.entidad.EntradaBlog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntradaBlogTests {
    private EntradaBlog entradaBlog;

    @BeforeEach
    public void setup() throws NoSuchFieldException, IllegalAccessException {
        resetIdField();
        entradaBlog = new EntradaBlog("Test Title", "Test Author", LocalDate.now());
    }

    private void resetIdField() throws NoSuchFieldException, IllegalAccessException {
        Field field = EntradaBlog.class.getDeclaredField("id");
        field.setAccessible(true);
        field.set(null, 0);
    }
    @Test
    void shouldReturnCorrectId() {
        assertEquals(1, entradaBlog.getId());
    }

    @Test
    void shouldReturnCorrectTitle() {
        assertEquals("Test Title", entradaBlog.getTitulo());
    }

    @Test
    void shouldUpdateTitleCorrectly() {
        entradaBlog.setTitulo("New Title");
        assertEquals("New Title", entradaBlog.getTitulo());
    }

    @Test
    void shouldReturnCorrectAuthor() {
        assertEquals("Test Author", entradaBlog.getAutor());
    }

    @Test
    void shouldUpdateAuthorCorrectly() {
        entradaBlog.setAutor("New Author");
        assertEquals("New Author", entradaBlog.getAutor());
    }

    @Test
    void shouldReturnCorrectPublicationDate() {
        assertEquals(LocalDate.now(), entradaBlog.getFechaPublicacion());
    }

    @Test
    void shouldUpdatePublicationDateCorrectly() {
        LocalDate newDate = LocalDate.of(2022, 1, 1);
        entradaBlog.setFechaPublicacion(newDate);
        assertEquals(newDate, entradaBlog.getFechaPublicacion());
    }
}