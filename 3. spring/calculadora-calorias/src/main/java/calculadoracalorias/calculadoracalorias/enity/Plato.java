package calculadoracalorias.calculadoracalorias.enity;

import lombok.Data;

import java.util.List;

@Data
public class Plato {
    private String nombre;
    List<Ingrediente> ingredientes;
    Ingrediente ingredienteConMasCalorias;

    public Plato(String nombre, List<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.ingredienteConMasCalorias = null;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public Ingrediente ingredienteConMasCalorias() {
        Ingrediente masCalorico = null;

        for(Ingrediente ingrediente : this.ingredientes){
            if(masCalorico == null || masCalorico.getCalories() < ingrediente.getCalories()) {
                masCalorico = ingrediente;
            }
        }

        return masCalorico;
    }

    public int getCaloriasTotales() {
        int caloriasTotales = 0;

        for (Ingrediente ingrediente : ingredientes){
            caloriasTotales += ingrediente.getCalories();
        }

        return caloriasTotales;
    }
}
