package org.example.modelo;

public class SocorristaAuto extends Socorrista<Auto> {
    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto " + auto.getPatente());
    }

}
