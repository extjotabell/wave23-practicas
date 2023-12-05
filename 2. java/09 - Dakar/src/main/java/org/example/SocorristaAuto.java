package org.example;

public class SocorristaAuto extends Vehiculo implements ISocorrista {
    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Auto) {
            System.out.println("Socorriendo auto " + vehiculo.getPatente());
        }else{
            System.out.println("Vehiculo incorrecto");
        }
    }
}
