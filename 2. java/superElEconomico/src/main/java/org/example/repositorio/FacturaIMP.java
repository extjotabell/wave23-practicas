package org.example.repositorio;
import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaIMP implements ICrudRepositorio <Factura>{

    private static FacturaIMP instancia;
    List <Factura> facturaList = new ArrayList<>();

    public static FacturaIMP getInstancia() {
        if (instancia == null) {
            instancia = new FacturaIMP();
        }
        return instancia;
    }

    public void creaFacturaValidada(Factura factura, ClienteIMP clienteIMP) {
        if(!clienteIMP.validaCliente(factura.getCli())){
            clienteIMP.guardar(factura.getCli());
        }
        this.guardar(factura);
    }

    @Override
    public void guardar(Factura objeto) {
        facturaList.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Factura factura:facturaList){
            System.out.println("====================================");
            System.out.println("CODIGO: " + factura.getCodigo());
            System.out.println("CLIENTE: " + factura.getCli());
            System.out.println("LISTA DE ITEMS:");
            System.out.println("------------------------------------");
            for (Item item : factura.getListaItems()) {
                System.out.println("CODIGO: "      + item.getCodigo());
                System.out.println("NOMBRE: "   + item.getNombre());
                System.out.println("CANTIDAD: " + item.getCantidad());
                System.out.println("COSTO UNITARIO: " + item.getCostoUnitario());
            }
            System.out.println("------------------------------------");
            System.out.println("TOTAL: " + factura.getTotal());
            System.out.println("====================================");
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigo) {
        boolean encontradoBuscar = false;
        for (Factura factura: facturaList) {
            if (factura.getCodigo().equals(codigo)) {
                System.out.println("FACTURA ENCONTRADA");
                System.out.println(factura.toString());
                return Optional.of(factura);
            }
        }
        if (encontradoBuscar == false) {
            System.out.println(("NO SE ENCONTRO FACTURA BUSCADA"));
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Factura> factura = this.buscar(codigoBorrado);
        if (factura.isEmpty()) {
            System.out.println(("NO SE ENCONTRO FACTURA A ELIMINAR"));
        } else {
            facturaList.remove(factura.get());
            System.out.println(("FACTURA ELIMINAAO CORRECTAMENTE"));
        }
    }

    @Override
    public List<Factura> mostrarTodos() {
        return facturaList;
    }
}
