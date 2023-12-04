package bootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Cliente {
   private String dni;
   private String nombre;
   private String apellido;

   public static ArrayList<Cliente> clientes = new ArrayList<>(List.of(
           new Cliente("1","Nicolás", "Diaz"),
           new Cliente("2", "Silvia", "Rodriguez"),
           new Cliente("3", "Víctor","Medina")
   ));;

   public static void imprimirDatosClientes(List<Cliente> clientes) {
        clientes.forEach(System.out::println);
   }

   public static void buscarClientePorDNI(List<Cliente> clientes, String dni) {
       Optional<Cliente> cliente = clientes.stream().filter(c -> c.getDni().equals(dni)).findAny();
       if (cliente.isPresent()) System.out.println(cliente.get());
       else System.out.println("Cliente no encontrado");
   }



   public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
   }

   public String getDni() {
        return dni;
   }

   public void setDni(String dni) {
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
        String dni = teclado.nextLine();
        System.out.println("Ingresa el nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Ingresa el apellido: ");
        String apellido = teclado.nextLine();
        return new Cliente(dni, nombre, apellido);
    }
}
