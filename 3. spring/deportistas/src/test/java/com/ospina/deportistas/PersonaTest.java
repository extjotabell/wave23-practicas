package com.ospina.deportistas;

import com.ospina.deportistas.entidad.Persona;
import com.ospina.deportistas.entidad.Deporte;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {

    @Test
    public void deberiaRetornarNombreCorrecto() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        assertEquals("John", persona.getNombre());
    }

    @Test
    public void deberiaRetornarApellidoCorrecto() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        assertEquals("Doe", persona.getApellido());
    }

    @Test
    public void deberiaRetornarEdadCorrecta() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        assertEquals(30, persona.getEdad());
    }

    @Test
    public void deberiaRetornarDeporteCorrecto() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        assertEquals(deporte, persona.getDeporte());
    }

    @Test
    public void deberiaActualizarNombreCorrectamente() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        persona.setNombre("Jane");
        assertEquals("Jane", persona.getNombre());
    }

    @Test
    public void deberiaActualizarApellidoCorrectamente() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        persona.setApellido("Smith");
        assertEquals("Smith", persona.getApellido());
    }

    @Test
    public void deberiaActualizarEdadCorrectamente() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        persona.setEdad(35);
        assertEquals(35, persona.getEdad());
    }

    @Test
    public void deberiaActualizarDeporteCorrectamente() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        Persona persona = new Persona("John", "Doe", 30, deporte);
        Deporte nuevoDeporte = new Deporte("Baloncesto", "Amateur");
        persona.setDeporte(nuevoDeporte);
        assertEquals(nuevoDeporte, persona.getDeporte());
    }
}