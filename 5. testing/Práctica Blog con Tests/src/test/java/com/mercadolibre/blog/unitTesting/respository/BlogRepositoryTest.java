package com.mercadolibre.blog.unitTesting.respository;

import com.mercadolibre.blog.entity.EntradaBlog;
import com.mercadolibre.blog.repository.BlogRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static com.mercadolibre.blog.utils.FactoryObjetcts.getInstanciaDeEntradaBlog;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class BlogRepositoryTest {

    @Autowired
    private BlogRepositoryImpl repository;
    private EntradaBlog entrada;

    @BeforeEach
    public void setup(){
        this.entrada = getInstanciaDeEntradaBlog();
    }

    @Test
    @DisplayName("Test: crearEntrada")
    public void crearEntradaOk(){
        //Act
        Assertions.assertNotNull(repository.crearEntrada(entrada));
    }

    @Test
    @DisplayName("Test: buscarId")
    public void buscarIdOK(){
        //Act
        repository.crearEntrada(entrada);
        EntradaBlog obtained = repository.buscarId(1);

        //Assert
        assertEquals("Entrada1", obtained.getTitulo());
    }

    @Test
    @DisplayName("Test: buscarId Null")
    public void buscarIdNull(){
        //Assert
        assertNull(repository.buscarId(2));
    }

    @Test
    @DisplayName("Test: buscarTodas")
    public void buscarTodasOK(){
        //Act
        List<EntradaBlog> actual = repository.buscarTodas();
        //Assert
        assertEquals(0, actual.size());
    }
}
