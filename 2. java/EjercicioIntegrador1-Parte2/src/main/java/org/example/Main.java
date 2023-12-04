package org.example;

import org.example.repositorio.ClienteImplemenctacion;
import org.example.repositorio.FacturaImplementacion;
import org.example.repositorio.ItemImplementacion;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        ClienteImplemenctacion cli = new ClienteImplemenctacion();
        FacturaImplementacion fac = new FacturaImplementacion();
        ItemImplementacion item = new ItemImplementacion();

        Cliente cliente1 = new Cliente(12345673, "Nico", "Reinaldo");
        Cliente cliente2 = new Cliente(24344244, "Lolo", "Manss");
        Cliente cliente3 = new Cliente(43097714, "Abril", "Bonna");


        cli.save(cliente1);
        cli.save(cliente2);
        cli.save(cliente3);

        cli.mostrarPantalla();

        cli.buscar(12345673);

        cli.eliminar(43097714);

        Item item1 = new Item(1234,"Coca",1,50);
        Item item2 = new Item(12345,"Pepsi",2,100);

        item.save(item1);
        item.save(item2);

        Factura fact1 = new Factura(12345,cliente1,item.traerTodos());

        fac.save(fact1);

        System.out.println(fact1.getTotal());


    }
}