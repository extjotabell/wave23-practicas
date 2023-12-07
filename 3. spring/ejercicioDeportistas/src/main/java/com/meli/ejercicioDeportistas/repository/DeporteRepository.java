package com.meli.ejercicioDeportistas.repository;

import com.meli.ejercicioDeportistas.model.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeporteRepository {
    private List<Deporte> deportes;

    public List<Deporte> getAllDeportes(){
        return new ArrayList<>(){{
            add(new Deporte("Futbol", "Avanzado"));
            add(new Deporte("Basket", "Intermedio"));
            add(new Deporte("Golf", "Avanzando"));
            add(new Deporte("Hockey", "Principiante"));
            add(new Deporte("Basket", "Principiante"));
        }};
    }
}
