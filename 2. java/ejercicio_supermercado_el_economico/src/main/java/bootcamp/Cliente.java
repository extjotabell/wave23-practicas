package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Cliente {
   private Long dni;
   private String nombre;
   private String apellido;
   public Cliente(Long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
   }

   public Long getDni() {
        return dni;
   }

   public void setDni(Long dni) {
        this.dni = dni;
   }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    static public Cliente crearCliente() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingresa el dni: ");
        Long dni = teclado.nextLong();
        System.out.println("Ingresa el nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa el apellido: ");
        String apellido = teclado.nextLine();
        return new Cliente(dni, nombre, apellido);
    }
}
