package com.ospina.deportistas;

import com.ospina.deportistas.controlador.ControladorPersona;
import com.ospina.deportistas.entidad.PersonaDeportistaDTO;
import com.ospina.deportistas.servicio.persona.PersonaServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControladorPersonaTest {

    @InjectMocks
    private ControladorPersona controladorPersona;

    @Mock
    private PersonaServicio personaServicio;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaCorrecta() {
        List<PersonaDeportistaDTO> listaPersonas = List.of(
                new PersonaDeportistaDTO("Juan", "Perez", "Futbol"),
                new PersonaDeportistaDTO("Pedro", "Gomez", "Basketball")
        );
        when(personaServicio.obtenerTodos()).thenReturn(listaPersonas);

        ResponseEntity<List<PersonaDeportistaDTO>> resultado = controladorPersona.obtenerTodos();

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(2, resultado.getBody().size());
        assertEquals("Juan", resultado.getBody().get(0).getNombre());
        assertEquals("Perez", resultado.getBody().get(0).getApellido());
        assertEquals("Futbol", resultado.getBody().get(0).getNombreDeporte());
    }

    @Test
    public void obtenerTodosDeberiaRetornarListaVaciaSiNoHayPersonas() {
        when(personaServicio.obtenerTodos()).thenReturn(List.of());

        ResponseEntity<List<PersonaDeportistaDTO>> resultado = controladorPersona.obtenerTodos();

        assertEquals(200, resultado.getStatusCodeValue());
        assertEquals(0, resultado.getBody().size());
    }
}