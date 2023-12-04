package repository;

import model.Factura;
import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepository implements CRUD<Factura>{

    private ArrayList<Factura> listaFacturas = new ArrayList<>();

    @Override
    public void alta(Factura obj) {
    listaFacturas.add(obj);
    }

    @Override
    public void baja(String numeroFactura) {
        List<Factura> resultadoBusqueda = this.listaFacturas.stream().filter(c -> c.getNumeroFactura().equals(numeroFactura)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Cliente no encontrado");
        }else{
            this.listaFacturas.remove(resultadoBusqueda.get(0));
            System.out.println("model.Cliente eliminado");
        }
    }

    @Override
    public Factura buscarPorId(String numeroFactura) {
        List<Factura> resultadoBusqueda = listaFacturas.stream().filter(c -> c.getNumeroFactura().equals(numeroFactura)).toList();
        if(resultadoBusqueda.isEmpty()){
            System.out.println("model.Producto no encontrado");
            return null;
        }else{
            System.out.println(resultadoBusqueda.get(0));
            return resultadoBusqueda.get(0);
        }
    }

    @Override
    public List<Factura> obtenerTodos() {
        return this.listaFacturas;
    }
}
