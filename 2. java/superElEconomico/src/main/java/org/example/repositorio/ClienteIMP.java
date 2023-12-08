package org.example.repositorio;
import org.example.model.Cliente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteIMP implements ICrudRepositorio<Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void guardar(Cliente objeto) {
        listaClientes.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Cliente c: listaClientes){
            System.out.println("DNI: "      + c.getDni());
            System.out.println("NOMBRE: "   + c.getNombre());
            System.out.println("APELIIDO: " + c.getApellido());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean encontradoBuscar = false;
        for (Cliente c: listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("CLIENTE ENCONTRADO");
                System.out.println("DNI: "      + c.getDni());
                System.out.println("NOMBRE: "   + c.getNombre());
                System.out.println("APELIIDO: " + c.getApellido());
                encontradoBuscar = true;
                return Optional.of(c);
            }
        }
        if (encontradoBuscar == false) {
            System.out.println(("NO SE ENCONTRO CLIENTE BUSCADO"));
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long idBorrado) {
        Optional<Cliente> cliente = this.buscar(idBorrado);
        if (cliente.isEmpty()) {
            System.out.println(("NO SE ENCONTRO CLIENTE A ELIMINAR"));
        } else {
            listaClientes.remove(cliente.get());
            System.out.println(("CLIENTE ELIMINADO CORRECTAMENTE"));
        }
    }

    @Override
    public List<Cliente> mostrarTodos() {
        return listaClientes;
    }

    public boolean validaCliente(Cliente cliente){
        return listaClientes.contains(cliente);
    }

}
