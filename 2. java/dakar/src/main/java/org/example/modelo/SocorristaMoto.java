package org.example.modelo;

public class SocorristaMoto extends Socorrista <Moto> {
    @Override
    void socorrer(Moto moto) {
        System.out.println("Socorriendo moto patente: " + moto.getPatente());
    }
}
