package org.socorristas;

import org.vehiculos.Vehiculo;

public interface Socorrista<T extends Vehiculo> {

    void socorrer(T vehiculo);

}
