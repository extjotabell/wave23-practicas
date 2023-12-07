package com.ospina.deportistas.servicio.deporte;

import com.ospina.deportistas.entidad.Deporte;
import com.ospina.deportistas.excepcion.DeporteNoEncontradoExcepcion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServicioImpl implements DeporteServicio{

    private final List<Deporte> deportes = List.of(
            new Deporte("Futbol", "Profesional"),
            new Deporte("Baloncesto", "Profesional"),
            new Deporte("Ciclismo", "Profesional"),
            new Deporte("Futbol", "Amateur"),
            new Deporte("Baloncesto", "Amateur"),
            new Deporte("Ciclismo", "Amateur")
    );

    @Override
    public List<Deporte> obtenerTodos() {
        return deportes;
    }

    @Override
    public Deporte obtenerPorNombre(String nombre) throws DeporteNoEncontradoExcepcion {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(DeporteNoEncontradoExcepcion::new);
    }
}
