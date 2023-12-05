package org.example.socorristas;

import org.example.socorristas.Socorrista;
import org.example.vehiculos.Moto;

public class SocorristaMoto implements Socorrista<Moto> {

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto: " + vehiculo.getPatente());
    }
}
