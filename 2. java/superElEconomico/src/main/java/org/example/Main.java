package org.example;
import org.example.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //crear clientes
        Cliente cliente1 = new Cliente("15708543", "Greta", "Molina");
        Cliente cliente2 = new Cliente("17706601", "Vicky", "Silva");
        Cliente cliente3 = new Cliente("19708543", "Mati", "Rojas");

        List<Cliente> listaClientes = new ArrayList<Cliente>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);

        //mostrar clientes por pantalla
        for (Cliente c: listaClientes){
            System.out.println("DNI: "      + c.getDni());
            System.out.println("NOMBRE: "   + c.getNombre());
            System.out.println("APELIIDO: " + c.getApellido());
        }

        //eliminar cliente
        Scanner leerTeclado = new Scanner(System.in);
        System.out.println("INGRESE DNI DE PERSONA A ELIMINAR: ");
        String dniEliminado = leerTeclado.next();

        boolean encontradoEliminar = false;
        for (Cliente c: listaClientes) {
            if (c.getDni().equals(dniEliminado)) {
                listaClientes.remove(c);
                encontradoEliminar = true;
                break;
            }
        }
        if (encontradoEliminar == false) {
            System.out.println(("NO SE ENCONTRO CLIENTE A ELIMINAR"));
        } else {
            System.out.println(("CLIENTE ELIMINADO CORRECTAMENTE"));
        }

        //busqueda de un cliente particualar
        System.out.println("INGRESE DNI DE PERSONA A BUSCAR: ");
        String dniBuscado = leerTeclado.next();

        boolean encontradoBuscar = false;
        for (Cliente c: listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("CLIENTE ENCONTRADO");
                System.out.println("DNI: "      + c.getDni());
                System.out.println("NOMBRE: "   + c.getNombre());
                System.out.println("APELIIDO: " + c.getApellido());
                encontradoBuscar = true;
                break;
            }
        }
        if (encontradoBuscar == false) {
            System.out.println(("NO SE ENCONTRO CLIENTE BUSCADO"));
        }
    }
}