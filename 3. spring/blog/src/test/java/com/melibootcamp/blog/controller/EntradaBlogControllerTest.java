package com.melibootcamp.blog.controller;

import com.melibootcamp.blog.dto.EntradaBlogDTO;
import com.melibootcamp.blog.dto.response.NuevaEntradaResponseDTO;
import com.melibootcamp.blog.entity.EntradaBlog;
import com.melibootcamp.blog.exceptions.IdDuplicadoException;
import com.melibootcamp.blog.repository.EntradaBlogRepository;
import com.melibootcamp.blog.services.EntradaBlogServiceImpl;
import org.apache.coyote.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class EntradaBlogControllerTest {
    @Mock
    EntradaBlogRepository entradaBlogRepository;
    @InjectMocks
    EntradaBlogServiceImpl entradaBlogService;
    EntradaBlogController entradaBlogController = new EntradaBlogController();

    @Test
    public void crearEntradaTest(){
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO("id","titulo", "nombreDeAutor");
        NuevaEntradaResponseDTO entradaResponseDTO = new NuevaEntradaResponseDTO("Entrada creada exitosamente. Id: " + entradaBlogDTO.getId());
        ResponseEntity<?> expectedResponse = entradaBlogController.crearEntrada(entradaBlogDTO);
        assertThat(new ResponseEntity<>(entradaResponseDTO, HttpStatus.OK)).isEqualTo(expectedResponse);
    }

    @Test
    public void crearEntradaExistenteTest(){
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO("id","titulo", "nombreDeAutor");
        entradaBlogController.crearEntrada(entradaBlogDTO);
        assertThrows(IdDuplicadoException.class,()->entradaBlogController.crearEntrada(entradaBlogDTO));
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> obtenerEntradaDeId(@PathVariable String id){
        return new ResponseEntity<>(entradaBlogService.buscarEntrada(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> obtenerTodasLasEntradas(){
        return new ResponseEntity<>(entradaBlogService.todasLasEntradas(), HttpStatus.OK);
    }
}
