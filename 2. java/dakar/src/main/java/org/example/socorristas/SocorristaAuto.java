package org.example.socorristas;

import org.example.socorristas.Socorrista;
import org.example.vehiculos.Auto;

public class SocorristaAuto implements Socorrista<Auto> {
    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto: " + vehiculo.getPatente());
    }
}
