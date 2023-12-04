package org.example;

public class SocorristaMoto extends Vehiculo implements ISocorrista {
    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            System.out.println("Socorriendo moto " + vehiculo.getPatente());
        }
    }
}
