package repository;

import model.Cliente;
import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class ProductoRepository implements CRUD<Producto> {

    private ArrayList<Producto> listaProductos = new ArrayList<>();

    @Override
    public void alta(Producto obj) {
        listaProductos.add(obj);
    }

    @Override
    public void baja(String codigo) {
        List<Producto> resultadoBusqueda = this.listaProductos.stream().filter(c -> c.getCodigo().equals(codigo)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
        }else{
            this.listaProductos.remove(resultadoBusqueda.get(0));
            System.out.println("model.Cliente eliminado");
        }
    }

    @Override
    public Producto buscarPorId(String codigo) {
        List<Producto> resultadoBusqueda = listaProductos.stream().filter(c -> c.getCodigo().equals(codigo)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Producto no encontrado");
            return null;
        }else{
            System.out.println(resultadoBusqueda.get(0));
            return resultadoBusqueda.get(0);
        }
    }

    @Override
    public List<Producto> obtenerTodos() {
        return this.listaProductos;
    }
}
