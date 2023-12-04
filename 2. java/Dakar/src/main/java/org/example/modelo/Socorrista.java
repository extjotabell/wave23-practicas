package org.example.modelo;

public abstract class Socorrista<T extends Vehiculo> {
    abstract void socorrer(T vehiculo);
}
