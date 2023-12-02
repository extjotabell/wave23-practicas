package org.mercadolibre.ejercicios.ejercicio1.model;

public abstract class Customer implements ITransaction{
    private int id;
    private String name;
    private String dni;

    public Customer(int id, String name, String dni) {
        this.id = id;
        this.name = name;
        this.dni = dni;
    }


}
