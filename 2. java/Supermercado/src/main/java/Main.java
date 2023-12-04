import models.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Supermercado singleton = Supermercado.getInstance();

        singleton.getClientes().add(new Cliente("44967716", "Felipe","Costa"));
        singleton.getClientes().add(new Cliente("32133426", "Jorge","Perez"));
        Cliente pepe = new Cliente("24742497", "Pepe","Gutierrez");
        singleton.getClientes().add(pepe);
        singleton.getClientes().showAll();

        System.out.println("Eliminando a Pepe por su DNI");
        System.out.println(singleton.getClientes().delete("24742497")?"Se elimino correctamente":"Ocurrio un error");

        singleton.getClientes().showAll();

        System.out.print("Ingrese el DNI del usuario a mostrar:");
        singleton.getClientes().showById(scanner.next());

        Producto p1 = new Producto(200, "Chocolate", "1");
        Producto p2 = new Producto(450, "Pollo", "2");

        singleton.getProductos().add(p1);
        singleton.getProductos().add(p2);

        Factura factura = new Factura("1",pepe, List.of(new Item(p1,3), new Item(p2,1)));
        singleton.getFacturas().add(factura);

        singleton.getClientes().showAll();

        System.out.println("Listar facturas");
        singleton.getFacturas().showAll();



    }
}
