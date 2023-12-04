package org.ejercicio;

import org.ejercicio.modelo.*;

import java.util.*;

public class Main {
    public static RegistroContable registroContable;
    public static RegistroClientes registroClientes;

    public static void main(String[] args) {
        registroContable = new RegistroContable(new ArrayList<>());
        registroClientes = new RegistroClientes(new ArrayList<>());
        //-----------------SPRINT 2 BONUS
        cargarClientes();
        actualizarCLiente();
        eliminarCliente("3412007");
        eliminarCliente("341200");
        // Facturas:
        cargarFacturas();
        mostrarInfoFacturas();
        actualizarFactura();
        eliminarFactura(100000);
    }

    public static void cargarClientes(){
        Cliente clienteUno = new Cliente("3412007", "Daniel", "Jimenez");
        Cliente clienteDos = new Cliente("3423001", "Emilia", "Vargas");
        Cliente clienteTres = new Cliente("3412034", "Paula", "Lopez");
        registroClientes.guardar(clienteUno);
        registroClientes.guardar(clienteDos);
        registroClientes.guardar(clienteTres);

        System.out.println("CLIENTES REGISTRADOS: ");
        Main.mostrarInfoClientes();
    }

    public static void mostrarInfoClientes(){
        registroClientes.mostrar();
    }

    private static void actualizarCLiente() {
        Cliente clienteUnoNuevo = new Cliente("3412007", "Daniel", "Ardila");
        registroClientes.actualizar(clienteUnoNuevo);
        System.out.println("CLIENTE ACTUALIZADO:");
        mostrarInfoClientes();
    }

    public static void eliminarCliente(String dniEliminar) {
        Optional<Cliente> clienteAux = registroClientes.getClientes().stream().filter(c -> c.getDni().equals(dniEliminar) ).findFirst();
        if( clienteAux.isPresent()) registroClientes.getClientes().remove(clienteAux.get());
        else System.out.println("El cliente con DNI "+ dniEliminar + " no existe.");
    }

    private static void cargarFacturas() {
        Cliente clienteFacturaUno = new Cliente("3412231", "Paulina", "Lopez");
        Item itemUno = new Item("00001", "1 LB ARROZ", 3, 5500);
        Item itemDos= new Item("00002", "3 L ACEITE", 9, 27000);
        Item itemTres = new Item("00003", "1 LB HARINA", 15, 4500);
        ArrayList<Item> itemsARegistrar = new ArrayList<>();
        itemsARegistrar.addAll(List.of(itemUno, itemDos, itemTres));

        if (!registroClientes.getClientes().contains(clienteFacturaUno)) registroClientes.guardar(clienteFacturaUno);
        Factura factura = new Factura(100000,clienteFacturaUno, itemsARegistrar, Factura.calcularTotalCompra(itemsARegistrar));
        registroContable.guardar(factura);
    }
    public static void mostrarInfoFacturas(){
        registroContable.mostrar();
    }
    private static void actualizarFactura() {
        Cliente clienteFacturaUno = new Cliente("3412231", "Paulina", "Lopez");
        Item itemUno = new Item("00001", "1 LB ARROZ", 3, 6500);
        Item itemDos= new Item("00002", "3 L ACEITE", 9, 27000);
        Item itemTres = new Item("00003", "1 LB HARINA", 150, 4500);
        ArrayList<Item> itemsARegistrar = new ArrayList<>();
        itemsARegistrar.addAll(List.of(itemUno, itemDos, itemTres));
        Factura facturaActualizada = new Factura(100000,clienteFacturaUno, itemsARegistrar, Factura.calcularTotalCompra(itemsARegistrar));
        registroContable.actualizar(facturaActualizada);

        System.out.println("FACTURA ACTUALIZADO:");
        mostrarInfoFacturas();
    }
    public static void eliminarFactura(long id) {
        Optional<Factura> facturaAux = registroContable.getFacturas().stream().filter(f -> f.getId() == (id) ).findFirst();
        if( facturaAux.isPresent()) registroContable.getFacturas().remove(facturaAux.get());
        else System.out.println("La factura con ID "+ id + " no existe.");
        mostrarInfoFacturas();
    }



}