package org.socorristas;

import org.vehiculos.Auto;

public class SocorristaAuto implements Socorrista<Auto>{

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto: " + vehiculo.getPatente());
    }
}
