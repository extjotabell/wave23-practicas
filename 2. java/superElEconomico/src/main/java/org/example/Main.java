package org.example;
import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.model.Item;
import org.example.repositorio.ClienteIMP;
import org.example.repositorio.FacturaIMP;
import org.example.repositorio.ItemIMP;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerTeclado = new Scanner(System.in);
        // ******* CLIENTES
        ClienteIMP clienteIMP = new ClienteIMP();
        //crear clientes y guardar
        Cliente cliente1 = new Cliente(15708543L, "Greta", "Molina");
        Cliente cliente2 = new Cliente(17706601L, "Vicky", "Silva");
        Cliente cliente3 = new Cliente(19708543L, "Mati", "Rojas");
        clienteIMP.guardar(cliente1);
        clienteIMP.guardar(cliente2);
        clienteIMP.guardar(cliente3);

        //mostrar clientes por pantalla
        System.out.println("====================================");
        System.out.println("--- MOSTRANDO CLIENTES ---");
        clienteIMP.mostrar();

        //busqueda de un cliente particualar
        System.out.println("====================================");
        System.out.println("INGRESE DNI DE PERSONA A BUSCAR: ");
        Long dniBuscado = leerTeclado.nextLong();
        clienteIMP.buscar(dniBuscado);

        //eliminar cliente
        System.out.println("====================================");
        System.out.println("INGRESE DNI DE PERSONA A ELIMINAR: ");
        Long dniEliminado = leerTeclado.nextLong();
        clienteIMP.eliminar(dniEliminado);

        System.out.println("--- MOSTRANDO TODOS LOS CLIENTES EN BASE DE DATOS ---");
        System.out.println(clienteIMP.mostrarTodos());

        // ******* ITEMS
        System.out.println("====================================");
        System.out.println("--- MOSTRANDO ITEMS ---");
        ItemIMP itemIMP = new ItemIMP();

        // ******* FACTURA
        FacturaIMP facturaIMP = FacturaIMP.getInstancia();
        List<Item> listaItems  = new ArrayList<>();
        Item item1 = new Item(1L,"Arroz",2,1000);
        Item item2 = new Item(2L,"Pan",2,890);
        listaItems.add(item1);
        listaItems.add(item2);
        Factura factura = new Factura(55777L, cliente1,listaItems);
        facturaIMP.creaFacturaValidada(factura,clienteIMP);
        itemIMP.guardar(item1);
        itemIMP.guardar(item2);
        itemIMP.mostrar();
        System.out.println("--- MOSTRANDO FACTURA ---");
        facturaIMP.mostrar();
    }
}