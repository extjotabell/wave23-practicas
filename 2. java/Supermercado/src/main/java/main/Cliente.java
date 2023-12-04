package main;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente: \n" +
                "DNI: " + dni + "\n" +
                "Nombre: " + nombre + "\n" +
                "Apellido: " + apellido;
    }

    public String getDni() {
        return dni;
    }
}
