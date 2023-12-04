package org.example.modelo;

public class SocorristaMoto extends Socorrista<Moto> {
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto " + moto.getPatente());
    }
}
