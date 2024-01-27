package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    ClienteRepository clienteRepository = new ClienteRepository();
    FacturaRepository facturaRepository = new FacturaRepository();

    public void registrarCliente(String dni, String nombre, String apellido){
        Cliente nuevoCliente = new Cliente(dni, nombre, apellido);
        clienteRepository.add(nuevoCliente);
    }

    public void mostrarClientes(){
        clienteRepository.showAll();
    }

    public void eliminarCliente(String id){
        clienteRepository.delete(id);
    }

    public void buscarClientePorDNI(String dni){
        System.out.println(clienteRepository.getModels().stream().map(cliente -> cliente.getDni().equals(dni)).toString());
    }

    public void crearFactura(String dni){
        facturaRepository.add(new Factura(clienteRepository.getById(dni),ingresarListaItems()));
    }

    private List<Item> ingresarListaItems(){
        List<Item> items = new ArrayList<>();
        String value = "1";
        String descripcion;
        Double precio;
        System.out.println("Ingrese los Items de la factura: ");
        while (!value.equals("0")){
            System.out.println("Descripcion: ");
            descripcion = scanner.nextLine();
            System.out.println("Precio: ");
            precio = Double.valueOf(scanner.nextLine());
            items.add(new Item(descripcion,precio));
            System.out.println("Desea continuar ingresando items? Ingrese 0 si desea detenerse");
            value = scanner.nextLine();
        }
        return items;
    }

    public menu(){
        String value = "";
        System.out.println(
                "El Economico - Sistema de Gestión \n" +
                "1-Crear Usuarios\n" +
                "2-Mostrar usuarios\n" +
                "3-Eliminar Usuario\n" +
                "4-Crear Factura\n" +
                "5-Eliminar Factura\n"
        );
        value = scanner.nextLine();
        switch (value) {
            case "1":{
                String dni;
                String nombre;
                String apellido;
                System.out.println(
                    "El Economico - Crear Usuarios \n" +
                    "DNI: ");
                dni = scanner.nextLine();
                System.out.println(
                    "Nombre: ");
                nombre = scanner.nextLine();
                System.out.println(
                    "Apellido: ");
                apellido = scanner.nextLine();
                registrarCliente(dni, nombre, apellido);
                break;
            }
            case "2": {
                mostrarClientes();
                break;
            }
            case "3": {
                System.out.println(
                    "El Economico - Eliminar Usuario\n" +
                    "Ingrese el DNI a eliminar: ");
                eliminarCliente(scanner.nextLine());
                break;
            }
            case "4": {
                System.out.println(
                        "El Economico - Eliminar Usuario\n" +
                                "Ingrese el DNI a facturar: ");
                crearFactura(scanner.nextLine());
                break;
            }
            case "5": {

            }
        }
    }

    public static void main(String[] args) {
        menu();
    }
}