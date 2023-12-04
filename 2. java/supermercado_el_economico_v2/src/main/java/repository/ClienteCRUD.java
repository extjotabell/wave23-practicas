package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD implements CRUDRepository<Cliente>{

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void create(Cliente obj) {
        clientes.add(obj);
    }

    @Override
    public Cliente read(int id) {
        return clientes.stream()
            .filter(c -> c.getDni() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Cliente> readAll() {
        return clientes;
    }

    @Override
    public void update(int id, Cliente obj) {
        Cliente cliente = read(id);

        cliente.setNombre(obj.getNombre());
        cliente.setApellido(obj.getApellido());
    }

    @Override
    public void delete(int id) {
        clientes.removeIf(c -> c.getDni() == id);
    }
}
