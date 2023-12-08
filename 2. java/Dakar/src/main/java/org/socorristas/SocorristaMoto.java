package org.socorristas;

import org.vehiculos.Moto;
import org.vehiculos.Vehiculo;

public class SocorristaMoto implements Socorrista<Moto> {


    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo Moto: " + moto.getPatente());
    }

}
