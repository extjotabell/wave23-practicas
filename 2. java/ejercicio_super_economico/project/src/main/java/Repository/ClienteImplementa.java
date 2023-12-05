package Repository;

import org.example.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteImplementa implements CRUD <Cliente> {

    List <Cliente> clientes = new ArrayList<Cliente>();
    @Override
    public void guardar(Cliente objeto) {
        clientes.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Cliente cliente: clientes){
            System.out.println(cliente);
        }
    }

    @Override
    public Optional<Cliente> buscar(int buscaDni) {
        if (clientes.stream().anyMatch(cliente -> cliente.getDni() == buscaDni)){
            List<Cliente> listaClientesFiltrada = clientes.stream()
                    .filter(cliente -> cliente.getDni() == buscaDni)
                    .collect(Collectors.toList());
            System.out.println(listaClientesFiltrada);}
        else {
            System.out.println("Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public List<Cliente> buscarTods() {
        return null;
    }

    @Override
    public void eliminar(int eliminaDni) {
        if (clientes.stream().anyMatch(cliente -> cliente.getDni().equals(eliminaDni))) {
            clientes.removeIf(cliente -> cliente.getDni().equals(eliminaDni));
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
