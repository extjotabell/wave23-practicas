package com.ospina.deportistas;

import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.excepcion.DeporteNoEncontradoExcepcion;
import com.ospina.deportistas.servicio.deporte.DeporteServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeporteServicioImplTest {

    @InjectMocks
    private DeporteServicioImpl deporteServicio;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaCorrecta() {
        List<Deporte> resultado = deporteServicio.obtenerTodos();

        assertEquals(6, resultado.size());
        assertEquals("Futbol", resultado.get(0).getNombre());
        assertEquals("Profesional", resultado.get(0).getNivel());
    }

    @Test
    public void obtenerPorNombreDeberiaRetornarDeporteCorrecto() throws DeporteNoEncontradoExcepcion {
        Deporte resultado = deporteServicio.obtenerPorNombre("Futbol");

        assertEquals("Futbol", resultado.getNombre());
        assertEquals("Profesional", resultado.getNivel());
    }

    @Test
    public void obtenerPorNombreDeberiaLanzarExcepcionSiNoSeEncuentraDeporte() {
        assertThrows(DeporteNoEncontradoExcepcion.class, () -> deporteServicio.obtenerPorNombre("Voleibol"));
    }
}
