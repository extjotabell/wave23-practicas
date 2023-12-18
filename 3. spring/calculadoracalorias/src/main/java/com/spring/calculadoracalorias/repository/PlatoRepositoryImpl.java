package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Data
@AllArgsConstructor
public class PlatoRepositoryImpl implements IPlatoRepository {

    List<Plato> platos;

    IngredienteRepositoryImpl ingredienteRepository;

    public PlatoRepositoryImpl() {
        ingredienteRepository = new IngredienteRepositoryImpl();
        platos = loadPlatos();
    }

    @Override
    public Plato getPlatos(String nombre) {
        return platos.stream().filter(p -> p.getNombre().toUpperCase().equals(nombre.toUpperCase())).findFirst().get();
    }


    private List<Plato> loadPlatos() {
            Map<Ingrediente, Integer> ingredientesPizza = new HashMap<>();
            ingredientesPizza.put(ingredienteRepository.buscarIngrediente("Queso mozzarella"), 200);
            ingredientesPizza.put(ingredienteRepository.buscarIngrediente("Salsa de tomate en conserva"), 100);
            ingredientesPizza.put(ingredienteRepository.buscarIngrediente("Harina de trigo refinada"), 200);
            ingredientesPizza.put(ingredienteRepository.buscarIngrediente("Jamón"), 200);
            Map<Ingrediente, Integer> ingredientesAguaDeLimon = new HashMap<>();
            ingredientesAguaDeLimon.put(ingredienteRepository.buscarIngrediente("Limón"), 100);
            ingredientesAguaDeLimon.put(ingredienteRepository.buscarIngrediente("Azúcar"), 100);
            return List.of(
                    new Plato("Pizza de Jamon", ingredientesPizza),
                    new Plato("Agua de Limon", ingredientesAguaDeLimon));
    }
}
