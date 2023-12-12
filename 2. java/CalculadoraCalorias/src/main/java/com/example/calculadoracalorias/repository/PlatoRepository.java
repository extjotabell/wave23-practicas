package com.example.calculadoracalorias.repository;

import com.example.calculadoracalorias.dto.IngredienteDTO;
import com.example.calculadoracalorias.dto.IngredienteItem;
import com.example.calculadoracalorias.dto.Plato;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlatoRepository {
    private List<Plato> platos;

    public PlatoRepository() {
        IngredienteDTO i1 = new IngredienteDTO("Aceitunas negras");
        IngredienteDTO i2 = new IngredienteDTO("Ajos");
        IngredienteDTO i3 = new IngredienteDTO("Berenjena");
        IngredienteDTO i4 = new IngredienteDTO("Perejil");
        IngredienteDTO i5 = new IngredienteDTO("Queso de oveja");
        IngredienteDTO i6 = new IngredienteDTO("Pollo");
        IngredienteDTO i7 = new IngredienteDTO("Tira de asado");
        IngredienteDTO i8 = new IngredienteDTO("Papas cocidas");
        Plato p1 = new Plato(List.of(
                new IngredienteItem(i1, 30),
                new IngredienteItem(i2, 10),
                new IngredienteItem(i3, 40),
                new IngredienteItem(i5, 20)
        ), "Ensalada");
        Plato p2 = new Plato(List.of(
                new IngredienteItem(i4, 5),
                new IngredienteItem(i6, 30),
                new IngredienteItem(i7, 30),
                new IngredienteItem(i8, 35)
        ), "Parrillada con papas");
        platos = List.of(
                p1, p2
        );
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public Plato getPlatoByName(String name) {
        return platos.stream().filter(plato -> plato.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
