package socorrista;

import models.Vehiculo;

public abstract class Socorrista {
    protected void socorrer(Vehiculo vehiculo){
        System.out.println("Socorriendo " + vehiculo.getClass().getSimpleName().toLowerCase() + " numero de patente: " + vehiculo.getPatente());
    }
}
