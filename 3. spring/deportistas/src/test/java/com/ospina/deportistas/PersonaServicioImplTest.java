package com.ospina.deportistas;

import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.entidad.Persona;
import com.ospina.deportistas.entidad.PersonaDeportistaDTO;
import com.ospina.deportistas.servicio.deporte.DeporteServicio;
import com.ospina.deportistas.servicio.persona.PersonaServicioImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PersonaServicioImplTest {

    @InjectMocks
    private PersonaServicioImpl personaServicio;

    @Mock
    private DeporteServicio deporteServicio;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaCorrecta() {
        Deporte deporte1 = new Deporte("Futbol", "Profesional");
        Deporte deporte2 = new Deporte("Basketball", "Amateur");
        Deporte deporte3 = new Deporte("Tennis", "Profesional");
        Deporte deporte4 = new Deporte("Swimming", "Amateur");
        Deporte deporte5 = new Deporte("Running", "Profesional");
        List<Deporte> listaDeportes = List.of(deporte1, deporte2, deporte3, deporte4, deporte5);
        when(deporteServicio.obtenerTodos()).thenReturn(listaDeportes);

        personaServicio.init();

        List<PersonaDeportistaDTO> resultado = personaServicio.obtenerTodos();

        assertEquals(5, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());
        assertEquals("Perez", resultado.get(0).getApellido());
        assertEquals("Futbol", resultado.get(0).getNombreDeporte());
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaVaciaSiNoHayPersonas() {
        when(deporteServicio.obtenerTodos()).thenReturn(List.of());

        personaServicio.init();

        List<PersonaDeportistaDTO> resultado = personaServicio.obtenerTodos();

        assertEquals(0, resultado.size());
    }
}