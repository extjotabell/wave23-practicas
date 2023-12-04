package repository;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;


public class ClienteRepository implements CRUD<Cliente>{

    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public void alta(Cliente obj) {
        listaClientes.add(obj);
    }

    @Override
    public void baja(String id) {
        List<Cliente> resultadoBusqueda = this.listaClientes.stream().filter(c -> c.getDni().equals(id)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
        }else{
            this.listaClientes.remove(resultadoBusqueda.get(0));
            System.out.println("model.Cliente eliminado");
        }
    }

    @Override
    public Cliente buscarPorId(String dni) {
        List<Cliente> resultadoBusqueda = listaClientes.stream().filter(c -> c.getDni().equals(dni)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
            return null;
        }else{
            System.out.println(resultadoBusqueda.get(0));
            return resultadoBusqueda.get(0);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return this.listaClientes;
    }
}
