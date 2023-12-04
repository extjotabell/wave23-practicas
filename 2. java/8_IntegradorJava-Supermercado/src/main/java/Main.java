import model.Cliente;
import model.Factura;
import model.Producto;
import repository.ClienteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Implementación PARTE I

        // Creando 3 clientes de prueba.
        Cliente cliente1 = new Cliente("1111", "José", "Pérez");
        Cliente cliente2 = new Cliente("2222", "Juan", "Ramirez");
        Cliente cliente3 = new Cliente("3333", "María", "Rosas");

        // Agregando los clientes a una Collection.
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        System.out.println("Lista original: ");
        // Recorriendo la lista de clientes y mostrando su información.
        clientes.stream().forEach(System.out::println);

        // Eliminando cliente.
        String dniBorrar1 = "2222";
        List<Cliente> resultadoBusqueda = clientes.stream().filter(c -> c.getDni().equals(dniBorrar1)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
        }else{
            clientes.remove(resultadoBusqueda.get(0));
            System.out.println("model.Cliente eliminado");
        }

        String dniBorrar2 = "1234";
        resultadoBusqueda = clientes.stream().filter(c -> c.getDni().equals(dniBorrar2)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
        }else{
            clientes.remove(resultadoBusqueda.get(0));
        }


        System.out.println("Lista después de una eliminación: ");
        // Recorriendo la lista de clientes y mostrando su información.
        clientes.stream().forEach(System.out::println);

        // Leyendo datos de teclado
        System.out.printf("Ingresa el DNI del cliente a buscar: ");
        Scanner scanner = new Scanner(System.in);

        String dniBuscado = scanner.nextLine();

        resultadoBusqueda = clientes.stream().filter(c -> c.getDni().equals(dniBuscado)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
        }else{
            System.out.println(resultadoBusqueda.get(0));
        }
        */


        //Parte II

        Cliente cliente1 = new Cliente("1111", "José", "Pérez");
        Cliente cliente2 = new Cliente("2222", "Juan", "Ramirez");
        Cliente cliente3 = new Cliente("3333", "María", "Rosas");

        ClienteRepository clientes = new ClienteRepository();
        clientes.alta(cliente1);
        clientes.alta(cliente2);
        clientes.alta(cliente3);

        clientes.obtenerTodos().forEach(System.out::println);

        String dniBorrar1 = "2222";
        clientes.baja(dniBorrar1);

        String dniBorrar2 = "1234";
        clientes.baja(dniBorrar2);

        clientes.obtenerTodos().forEach(System.out::println);

        String dniBuscar = "1111";
        System.out.println(clientes.buscarPorId(dniBuscar));

        Producto producto1 = new Producto("1111", "Leche", 10.0, 1);
        Producto producto2 = new Producto("2222", "Huevo", 5.5, 2);
        Producto producto3 = new Producto("3333", "Galletas", 4.2, 3);

        Factura factura1 = new Factura(cliente1);

        factura1.agregarProducto(producto1);
        factura1.agregarProducto(producto2);
        factura1.agregarProducto(producto3);

        System.out.printf("Total de la compra: %f", factura1.calcularTotal());


    }

}
