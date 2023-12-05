package org.mercadolibre.TourismAgency.model;

public class Customer {
    private int dni;
    private String name;
    private String lastname;

    public Customer() {
    }

    public Customer(int dni, String name, String lastname) {
        this.dni = dni;
        this.name = name;
        this.lastname = lastname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
