package org.example;


import java.util.Comparator;

public class Client implements Comparator<Client> {
    private Integer DNI;
    private String name;
    private String surname;

    public Client(Integer dni, String name, String surname) {
        this.DNI = dni;
        this.name = name;
        this.surname = surname;
    }

    public Client() {

    }

    @Override
    public String toString() {
        return "Client: " +
                "DNI: " + DNI +
                " Name: " + name +
                " Surname: " + surname;
    }

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getDNI().compareTo(o2.getDNI());
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
