package org.example.socorristas;

import org.example.vehiculos.Vehiculo;

public interface Socorrista<T extends Vehiculo> {

    void socorrer(T vehiculo);
}
