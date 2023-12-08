package org.example.modelo;

public class SocorristaAuto extends Socorrista<Auto> {
    @Override
    void socorrer(Auto auto) {
        System.out.println("Socorriendo auto patente: " + auto.getPatente());
    }
}
