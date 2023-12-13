package com.mercadolibre.calculadoraCalorias.repository;

import com.mercadolibre.calculadoraCalorias.entity.Receta;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RecetaRepositoryImpl implements IRecetaRepository {
    @Autowired
    IngredienteRepositoryImpl ingredienteRepository;
    List<Receta> recetas = new ArrayList<>();

    @PostConstruct
    private void loadData() {
        Receta pizza = new Receta("Pizza", List.of(

                ingredienteRepository.buscarIngrediente("Harina de maíz"),
                ingredienteRepository.buscarIngrediente("Tomate triturado en conserva"),
                ingredienteRepository.buscarIngrediente("Queso Brie")
        ));

        Receta helado = new Receta("Helado", List.of(
                ingredienteRepository.buscarIngrediente("Agua tónica"),
                ingredienteRepository.buscarIngrediente("Pera")
        ));

        recetas.add(pizza);
        recetas.add(helado);
    }

    @Override
    public Receta buscarReceta(String nombre) throws Exception {
        System.out.println("Buscando receta: " + nombre);
        Optional<Receta> receta = recetas.stream()
                .filter(r -> nombre.equalsIgnoreCase(r.getNombre()))
                .findFirst();

        if (receta.isEmpty()) {
            throw new Exception("No se encontró la receta solicitada");
        }
        return receta.get();
    }
}
