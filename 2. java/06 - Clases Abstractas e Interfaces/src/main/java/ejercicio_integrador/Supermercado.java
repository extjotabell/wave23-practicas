package ejercicio_integrador;

import java.util.List;
import java.util.Optional;

public class Supermercado {
    private String nombre;

    public Supermercado(String nombre) {
        this.nombre = nombre;
    }

    public static String buscarClienteByDni(List<Cliente> clientes, String dni){
        String result = "";
        Optional<Cliente> clienteEncontrado = clientes.stream()
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

    public static void eliminarCliente(List<Cliente> clientes, Cliente cliente){
        clientes.remove(cliente);
    }

    public static void mostrarClientes(List<Cliente> clientes){
        clientes.forEach(System.out::println);
        }
    }

