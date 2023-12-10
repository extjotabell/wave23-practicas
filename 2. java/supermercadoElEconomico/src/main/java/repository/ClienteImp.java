package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteImp implements CRUD<Cliente>{
    private List<Cliente> listaClientes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void agregar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void eliminar(Cliente cliente) {
        System.out.print("\n-----Lista Clientes, eliminando al cliente: " + cliente.getNombre() + " " +cliente.getApellido() + " -----\n");
        listaClientes.remove(cliente);
    }

    @Override
    public void actualizar(Cliente clienteViejo, Cliente clienteNuevo) {
        System.out.println("\n-----Lista clientes actualizado ------");
        int index = listaClientes.indexOf(clienteViejo);
        if (index != -1) {
            listaClientes.set(index, clienteNuevo);
        }
    }

    @Override
    public Cliente consultar(String criterio) {
        for (Cliente cliente : listaClientes) {
            if (String.valueOf(cliente.getDni()).equals(criterio)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void obtenerTodos() {
        listaClientes.forEach(clientes -> {
            System.out.print("Nombre: " + clientes.getNombre());
            System.out.print(" |-| Apellido: " + clientes.getApellido());
            System.out.print(" |-| DNI: " + clientes.getDni() + "\n");
        });
    }

    public void nuevoClienteID(int dniCliente) {
        Scanner sc = new Scanner(System.in);
        Cliente clienteExistente = consultar(String.valueOf(dniCliente));

        if(clienteExistente!=null){
            System.out.println("El cliente asociado a la factura ya está registrado.");
        }else {
            System.out.println("El cliente no está registrado. Se creará un nuevo cliente.");
            System.out.print("Ingrese el nombre del nuevo cliente: ");
            String nombreNuevoCliente = sc.nextLine();
            System.out.print("Ingrese el apellido del nuevo cliente: ");
            String apellidoNuevoCliente = sc.nextLine();

            Cliente nuevoCliente = new Cliente(nombreNuevoCliente, apellidoNuevoCliente, dniCliente);
            agregar(nuevoCliente);
            System.out.println(listaClientes.get(listaClientes.size()-1));
        }
    }

}
