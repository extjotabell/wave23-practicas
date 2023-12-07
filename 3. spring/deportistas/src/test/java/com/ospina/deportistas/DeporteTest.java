package com.ospina.deportistas;

import com.ospina.deportistas.entidad.Deporte;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeporteTest {

    @Test
    public void deberiaRetornarNombreCorrecto() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        assertEquals("Futbol", deporte.getNombre());
    }

    @Test
    public void deberiaRetornarNivelCorrecto() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        assertEquals("Profesional", deporte.getNivel());
    }

    @Test
    public void deberiaActualizarNombreCorrectamente() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        deporte.setNombre("Basketball");
        assertEquals("Basketball", deporte.getNombre());
    }

    @Test
    public void deberiaActualizarNivelCorrectamente() {
        Deporte deporte = new Deporte("Futbol", "Profesional");
        deporte.setNivel("Amateur");
        assertEquals("Amateur", deporte.getNivel());
    }
}
