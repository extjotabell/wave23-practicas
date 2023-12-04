package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("1234567","Cliente 1", "Apellido 1");
        Cliente cliente2 = new Cliente("12345678","Cliente 2", "Apellido 2");
        Cliente cliente3 = new Cliente("123456789","Cliente 3", "Apellido 3");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente);
        clientes.add(cliente2);
        clientes.add(cliente3);

        clientes.forEach(System.out::println);

        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese dni de la persona a borrar: ");

        String dniBorrar = scan.next();
        boolean encontrado = false;
        for(Cliente c : clientes){
            if(c.getDni().equals(dniBorrar)){
                clientes.remove(c);
                encontrado = true;
                break;
            }
        }

        if(encontrado){
            System.out.println("Se ha encontrado el cliente a borrar");
        }else{
            System.out.println("No se ha borrado el cliente");
        }

        Scanner scanBuscar = new Scanner(System.in);

        System.out.print("Ingrese dni de la persona a buscar: ");

        String dniBuscar = scan.next();
        encontrado = false;
        for(Cliente c : clientes){
            if(c.getDni().equals(dniBuscar)){
                System.out.println("Cliente encontrado.");
                System.out.println(c);
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            System.out.println("Cliente no encontrado");
        }
    }
}