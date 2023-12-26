package com.meli.ejercicioBlog.services;

import com.meli.ejercicioBlog.dtos.request.EntradaBlogCreacionRequestDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogListaResponseDTO;
import com.meli.ejercicioBlog.dtos.response.EntradaBlogResponseDTO;
import com.meli.ejercicioBlog.dtos.response.MessageResponseDTO;
import com.meli.ejercicioBlog.exceptions.AlreadyExistsException;
import com.meli.ejercicioBlog.exceptions.MalformedPayloadException;
import com.meli.ejercicioBlog.exceptions.ResourceNotFoundException;
import com.meli.ejercicioBlog.model.EntradaBlog;
import com.meli.ejercicioBlog.repository.EntradaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EntradaServiceTest {

    @Mock
    EntradaRepository repo;

    @InjectMocks
    EntradaService service;

    @Test
    @DisplayName("Creacion valido de entrada")
    void crearValido() {
        when(repo.create(any())).thenReturn("unIdCualquiera");
        EntradaBlogCreacionRequestDTO param = new EntradaBlogCreacionRequestDTO(
                "unIdCualquiera",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );
        MessageResponseDTO expectedResult = new MessageResponseDTO("unIdCualquiera");

        MessageResponseDTO result = service.crear(param);

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("Creacion nula de entrada")
    void crearInvalido() {
        assertThrows(MalformedPayloadException.class, () -> service.crear(null));
    }

    @Test
    @DisplayName("Creacion de entrada ya existente")
    void crearExistente() {
        when(repo.create(any())).thenReturn(null);
        EntradaBlogCreacionRequestDTO param = new EntradaBlogCreacionRequestDTO(
                "1",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );

        assertThrows(AlreadyExistsException.class, () -> service.crear(param));
    }

    @Test
    @DisplayName("Buscar entrada existente")
    void findExistente() {
        when(repo.find(any())).thenReturn(new EntradaBlog(
                        "idGenerico",
                        "Titulo generico",
                        "Juan perez",
                        "12-05-2017"
                )
        );
        EntradaBlogResponseDTO expectedResult = new EntradaBlogResponseDTO(
                "idGenerico",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        );

        EntradaBlogResponseDTO result = service.find("idGenerico");

        assertEquals(expectedResult.getId(), result.getId());
        assertEquals(expectedResult.getTitulo(), result.getTitulo());
        assertEquals(expectedResult.getNombreAutor(), result.getNombreAutor());
        assertEquals(expectedResult.getFechaPublicacion(), result.getFechaPublicacion());
    }

    @Test
    @DisplayName("Buscar entrada inexistente")
    void findInexistente() {
        when(repo.find(any())).thenReturn(null);
        assertThrows(ResourceNotFoundException.class, () -> service.find(null));
    }

    @Test
    @DisplayName("Obtener todas las entradas, existiendo al menos una")
    void getAll(){
        when(repo.getAll()).thenReturn(List.of(new EntradaBlog(
                "idGenerico",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        )));
        EntradaBlogListaResponseDTO expectedResult = new EntradaBlogListaResponseDTO(List.of(new EntradaBlogResponseDTO(
                "idGenerico",
                "Titulo generico",
                "Juan perez",
                "12-05-2017"
        )));

        EntradaBlogListaResponseDTO result = service.getAll();

        assertEquals(expectedResult.getEntradas().size(), result.getEntradas().size());
        assertEquals(expectedResult.getEntradas(), result.getEntradas());
    }

    @Test
    @DisplayName("Obtener todas las entradas, pero no hay ninguna")
    void getAllIsEmpty(){
        when(repo.getAll()).thenReturn(new ArrayList<>());

        assertThrows(ResourceNotFoundException.class, () -> service.getAll());
    }
}