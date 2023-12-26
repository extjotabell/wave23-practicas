package com.meli.ejercicioBlog.repository;

import com.meli.ejercicioBlog.model.EntradaBlog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EntradaRepositoryTest {

    @InjectMocks
    EntradaRepository repo;

    @Test
    @DisplayName("Creacion de entrada valida")
    void createEntradaValida() {
        EntradaBlog param = new EntradaBlog(
                "4",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );
        String expectedResult = "4";

        String result = repo.create(param);

        assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Creacion de entrada invalida")
    void createEntradaInvalida() {
        EntradaBlog param = new EntradaBlog(
                "1",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );
        String expectedResult = null;

        String result = repo.create(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Obtener entrada existente")
    void findExistente() {
        EntradaBlog expectedResult = new EntradaBlog("1", "TituloStandard1", "Juan perez", "12-04-2011");

        EntradaBlog result = repo.find("1");

        assertEquals(expectedResult, result);
    }
    @Test
    @DisplayName("Obtener entrada inexistente")
    void findInexistente() {
        EntradaBlog expectedResult = null;

        EntradaBlog result = repo.find("99");

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Obtener todas las entradas")
    void getAll() {
        List<EntradaBlog> expectedResult = new ArrayList<>();
        expectedResult.add(new EntradaBlog("1", "TituloStandard1", "Juan perez", "12-04-2011"));
        expectedResult.add(new EntradaBlog("2", "TituloStandard2", "Jose perez", "23-07-2007"));
        expectedResult.add(new EntradaBlog("3", "TituloStandard3", "Diego perez", "05-11-2019"));

        List<EntradaBlog> result = repo.getAll();

        assertEquals(expectedResult, result);
    }
}