package bootcamp;

import java.lang.ref.Cleaner;
import java.util.*;
import java.util.stream.IntStream;

public class ClienteImp implements CRUDInterface<Cliente> {

    private List<Cliente> clientes;

    public void buscarClientePorDNI(Long dni) {
        Optional<Cliente> cliente = clientes.stream().filter(c -> c.getDni().equals(dni)).findAny();
        if (cliente.isPresent()) System.out.println(cliente.get());
        else System.out.println("Cliente no encontrado");
    }

    public ClienteImp() {
        clientes = new ArrayList<>();
    }

    @Override
    public void save(Cliente element) {
        clientes.add(element);
    }

    @Override
    public boolean delete(Long id) {
        OptionalInt indexOpt = IntStream.range(0, clientes.size())
                .filter(i -> Objects.equals(id, clientes.get(i).getDni())).findFirst();
        if (indexOpt.isPresent()) clientes.remove(indexOpt.getAsInt());
        return indexOpt.isPresent();
    }

    @Override
    public List<Cliente> getElements() {
        return this.clientes;
    }

    @Override
    public Optional<Cliente> search(Long id) {
        return clientes.stream().filter(cliente -> cliente.getDni().equals(id)).findFirst();
    }

    @Override
    public void printElements() {
        System.out.println(this.clientes);
    }
}
