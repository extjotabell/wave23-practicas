import model.Cliente;

import repository.ClienteImp;
import repository.FacturaImp;
import repository.ItemImp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteImp clientes = new ClienteImp();
        ItemImp item = new ItemImp();
        FacturaImp factura = new FacturaImp();
        Cliente cliente = new Cliente("Andres", "Limpio", 1234);
        Cliente cliente2 = new Cliente("Marian", "Juarez", 5678);
        Cliente cliente3 = new Cliente("Carlos", "Cabeza", 7890);
        Cliente cliente4 = new Cliente("Marcos", "Sanchez", 1111);

        //Create clients
        clientes.agregar(cliente);
        clientes.agregar(cliente2);
        clientes.agregar(cliente3);
        clientes.agregar(cliente4);

        //Read all clients
        System.out.println("------Lista Clientes------");
        clientes.obtenerTodos();

        //Delete client
        clientes.eliminar(cliente2);
        clientes.obtenerTodos();

        //Update client
        Cliente clienteNuevo = new Cliente("María", "Gómez", 2027);
        clientes.actualizar(cliente3, clienteNuevo);
        clientes.obtenerTodos();

        System.out.print("\nCreación de nueva factura");
        System.out.print("\nInserta el dni de un número de cliente, para buscarlo: ");
        int dniCliente = sc.nextInt();
        clientes.nuevoClienteID(dniCliente);
        factura.crearFactura(dniCliente);


    }

}
