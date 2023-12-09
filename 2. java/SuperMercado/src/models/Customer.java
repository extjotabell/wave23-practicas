package models;

public class Customer {
    private int dni;
    private String name;
    private String lastName;

    public Customer() {
    }

    public Customer(int dni, String name, String lastName) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Detalles del cliente: \n" +
                "DNI: " + dni + '\n' +
                "Nombre: " + name + '\n' +
                "Apellido: " + lastName + '\n';
    }
}
