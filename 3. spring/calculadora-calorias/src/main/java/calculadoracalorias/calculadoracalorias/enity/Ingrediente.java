package calculadoracalorias.calculadoracalorias.enity;

import lombok.Data;

@Data
public class Ingrediente {
    private String name;
    private int calories;

    public String getName(){
        return this.name;
    }
    public int getCalories(){
        return this.calories;
    }
}
