package com.ospina.calculadoraCalorias.repositorio.plato;

import com.ospina.calculadoraCalorias.modelo.entidad.Ingrediente;
import com.ospina.calculadoraCalorias.modelo.entidad.Plato;
import com.ospina.calculadoraCalorias.repositorio.comida.RepositorioComida;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioPlatoImpl implements RepositorioPlato{

        
    private final RepositorioComida repositorioComida;
    private List<Plato> platos = new ArrayList<>();
    List<Ingrediente> ingredientes;

    public RepositorioPlatoImpl(RepositorioComida repositorioComida) {
        this.repositorioComida = repositorioComida;
    }

    @PostConstruct
    public void init(){
        try {
            ingredientes = obtenerIngredientes();
        } catch (Exception e) {
            System.err.println("Error inicialzando ingredientes: " + e.getMessage());
            ingredientes = new ArrayList<>();
        }
        Ingrediente pollo = buscarIngredientePorNombre(ingredientes, "Pollo"); 
        Ingrediente papas = buscarIngredientePorNombre(ingredientes, "Papas cocidas");
        Ingrediente salsaTomate = buscarIngredientePorNombre(ingredientes, "Salsa de tomate en conserva");
        platos.add(new Plato("Milanesa con papas fritas", new ArrayList<>(List.of(pollo, papas, salsaTomate))));

        Ingrediente lechuga = buscarIngredientePorNombre(ingredientes, "Lechuga");
        Ingrediente tomate = buscarIngredientePorNombre(ingredientes, "Tomates");
        Ingrediente cebolla = buscarIngredientePorNombre(ingredientes, "Cebolla");
        Ingrediente zanahoria = buscarIngredientePorNombre(ingredientes, "Zanahoria");
        platos.add(new Plato("Ensalada del chef", new ArrayList<>(List.of(lechuga, tomate, cebolla, zanahoria))));


        Ingrediente mayonesa = buscarIngredientePorNombre(ingredientes, "Mayonesa");
        Ingrediente hamburguesa = buscarIngredientePorNombre(ingredientes, "Hamburguesa");
        Ingrediente panDeCenteno = buscarIngredientePorNombre(ingredientes, "Pan de centeno");
        platos.add(new Plato("Hamburguesa pan centeno", new ArrayList<>(List.of(mayonesa, tomate, hamburguesa, panDeCenteno))));

        Ingrediente champinon = buscarIngredientePorNombre(ingredientes, "Champiñón y otras setas");
        Ingrediente salsaTomateP = buscarIngredientePorNombre(ingredientes, "Salsa de tomate en conserva");
        Ingrediente harina = buscarIngredientePorNombre(ingredientes, "Harina de trigo integrada");
        Ingrediente queso = buscarIngredientePorNombre(ingredientes, "Queso Mozzarella");
        Ingrediente salchichon = buscarIngredientePorNombre(ingredientes, "Salchichón");
        platos.add(new Plato("Pizza", new ArrayList<>(List.of(champinon, salsaTomateP, harina, queso, salchichon))));
    }

    @Override
    public List<Plato> obtenerTodos() {
        return platos;
    }

    @Override
    public Plato obtenerPorNombre(String nombre) {
        return platos.stream().filter(plato -> plato.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    public List<Ingrediente> obtenerIngredientes() {
        return repositorioComida.obtenerTodos();
    }
    private Ingrediente buscarIngredientePorNombre(List<Ingrediente> ingredientes, String nombre) {
        for (Ingrediente ingrediente : ingredientes) {
            if (ingrediente.getNombre().equals(nombre)) {
                return ingrediente;
            }
        }
        return null;
    }
}