package com.ospina.deportistas;

import com.ospina.deportistas.controlador.ControladorDeportes;
import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.excepcion.DeporteNoEncontradoExcepcion;
import com.ospina.deportistas.servicio.deporte.DeporteServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControladorDeportesTest {

    @InjectMocks
    private ControladorDeportes controladorDeportes;

    @Mock
    private DeporteServicio deporteServicio;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaCorrecta() {
        List<Deporte> listaDeportes = List.of(
                new Deporte("Futbol", "Profesional"),
                new Deporte("Basketball", "Amateur")
        );
        when(deporteServicio.obtenerTodos()).thenReturn(listaDeportes);

        ResponseEntity<List<Deporte>> resultado = controladorDeportes.obtenerTodos();

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(2, resultado.getBody().size());
        assertEquals("Futbol", resultado.getBody().get(0).getNombre());
        assertEquals("Profesional", resultado.getBody().get(0).getNivel());
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaVaciaSiNoHayDeportes() {
        when(deporteServicio.obtenerTodos()).thenReturn(List.of());

        ResponseEntity<List<Deporte>> resultado = controladorDeportes.obtenerTodos();

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(0, resultado.getBody().size());
    }

    @Test
    public void obtenerPorNombreDeberiaRetornarDeporteCorrecto() throws DeporteNoEncontradoExcepcion {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        when(deporteServicio.obtenerPorNombre("Futbol")).thenReturn(deporte);

        ResponseEntity<?> resultado = controladorDeportes.obtenerPorNombre("Futbol");

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(deporte, resultado.getBody());
    }

    @Test
    public void obtenerPorNombreDeberiaRetornarErrorSiNoSeEncuentraDeporte() throws DeporteNoEncontradoExcepcion {
        when(deporteServicio.obtenerPorNombre("Voleibol")).thenThrow(new DeporteNoEncontradoExcepcion());

        ResponseEntity<?> resultado = controladorDeportes.obtenerPorNombre("Voleibol");

        assertEquals(400, resultado.getStatusCodeValue());
        assertEquals("Error: El deporte no fue encontrado.", resultado.getBody());
    }
}