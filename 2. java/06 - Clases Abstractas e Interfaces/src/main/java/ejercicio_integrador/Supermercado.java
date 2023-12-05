package ejercicio_integrador;

import java.util.*;

public class Supermercado {
    private String nombre;
    private Set<Cliente> clientesList;
    private Map<Cliente, List<Factura>> facturacion;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.clientesList = new HashSet<>();
        this.facturacion = new HashMap<>();
    }

    public boolean clienteExiste(String dni){
        boolean flag;
        Optional<Cliente> clienteEncontrado = clientesList.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst();
        if(clienteEncontrado.isPresent()){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    public String buscarClienteByDni(String dni){
        String result = "";
        Optional<Cliente> clienteEncontrado = clientesList.stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst();
        if(clienteEncontrado.isPresent()){
            result = "Cliente encontrado. " +
                    "\nDNI:" + clienteEncontrado.get().getDni() +
                    "\nNombre:" + clienteEncontrado.get().getNombre() + " " + clienteEncontrado.get().getApellido();
        }else{
            result = "Cliente no encontrado";
        }
        return result;
    }

    public void eliminarCliente(Cliente cliente){
        clientesList.remove(cliente);
    }

    public void mostrarClientes(){
        clientesList.forEach(System.out::println);
        }

    public Factura generarFactura(Cliente cliente, List<Item> productos){
        boolean clienteExiste = clienteExiste(cliente.getDni());
        if(!clienteExiste){
            clientesList.add(cliente);
        }
        return new Factura(cliente, productos);
    }
    }

