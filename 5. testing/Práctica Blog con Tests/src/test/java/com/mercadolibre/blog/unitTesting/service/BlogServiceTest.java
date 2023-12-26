package com.mercadolibre.blog.unitTesting.service;

import com.mercadolibre.blog.dto.request.EntradaRequestDto;
import com.mercadolibre.blog.dto.response.EntradaIdDto;
import com.mercadolibre.blog.entity.EntradaBlog;
import com.mercadolibre.blog.exception.BadRequestException;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.repository.BlogRepositoryImpl;
import com.mercadolibre.blog.service.BlogServiceImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.mercadolibre.blog.utils.FactoryObjetcts.getInstanciaDeEntradaBlog;
import static com.mercadolibre.blog.utils.FactoryObjetcts.getInstanciaDeEntradaRequestDto;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class BlogServiceTest {

    @Mock
    private BlogRepositoryImpl repository;
    @InjectMocks
    private BlogServiceImpl service;
    private EntradaRequestDto entradaRequestDtoConId1;
    private EntradaBlog entradaBlogConId1;


    @BeforeEach
    public void setup(){
        entradaRequestDtoConId1 = getInstanciaDeEntradaRequestDto();
        entradaBlogConId1 = getInstanciaDeEntradaBlog();
    }

    @Test
    @DisplayName("Test: crearEntrada")
    public void crearEntradaOk(){
        when(repository.crearEntrada(any())).thenReturn(entradaBlogConId1);
        EntradaIdDto id = service.crearEntrada(entradaRequestDtoConId1);
        Assertions.assertEquals(1, id.getId());
    }

    @Test
    @DisplayName("Test: crearEntrada con objeto null")
    public void crearEntradaNull(){
        assertThrows(BadRequestException.class, ()->service.crearEntrada(null));
    }

    @Test
    @DisplayName("Test: crearEntrada mismo ID")
    public void crearEntradaMismoId(){
        //Llamado al repo
        when(repository.buscarId(1)).thenReturn(entradaBlogConId1);
        //Deberia lanzar excepcion
        assertThrows(BadRequestException.class, ()->service.crearEntrada(entradaRequestDtoConId1));
    }

    @Test
    @DisplayName("Test: buscarId")
    public void buscarPorIdOK(){
        Integer id = 1;
        when(repository.buscarId(any())).thenReturn(entradaBlogConId1);
        assertEquals(id, service.buscarPorId(1).getId());
    }

    @Test
    @DisplayName("Test: buscarId no se encuentra ese id")
    public void buscarPorIdNotOk(){
        when(repository.buscarId(any())).thenReturn(null);
        assertThrows(NotFoundException.class, ()->service.buscarPorId(1));
    }


    @Test
    @DisplayName("Test: buscarTodas")
    public void buscarTodasOK(){
        //Arrange
        when(repository.buscarTodas()).thenReturn(List.of(entradaBlogConId1));
        //Act + Assert
        assertEquals(1,service.buscarTodas().getEntradas().size());
    }

    @Test
    @DisplayName("Test: buscarTodas cuando no hay entradas cargadas")
    public void buscarTodasNotOk(){
        when(repository.buscarTodas()).thenReturn(new ArrayList<>());
        assertThrows(NotFoundException.class, ()->service.buscarTodas());
    }
}
