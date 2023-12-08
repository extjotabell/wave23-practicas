package org.example.repositorio;
import org.example.model.Cliente;
import org.example.model.Factura;
import org.example.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemIMP implements ICrudRepositorio<Item>{

    List <Item> itemList = new ArrayList<>();

    @Override
    public void guardar(Item objeto) {
        itemList.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Item i:itemList){
            System.out.println("CODIGO: "      + i.getCodigo());
            System.out.println("NOMBRE: "   + i.getNombre());
            System.out.println("CANTIDAD: " + i.getCantidad());
            System.out.println("COSTO UNITARIO: " + i.getCostoUnitario());
        }
    }

    @Override
    public Optional buscar(Long codigo) {
        boolean encontradoBuscar = false;
        for (Item i: itemList) {
            if (i.getCodigo().equals(codigo)) {
                System.out.println("ITEM ENCONTRADO");
                System.out.println(i.toString());
                return Optional.of(i);
            }
        }
        if (encontradoBuscar == false) {
            System.out.println(("NO SE ENCONTRO ITEM BUSCADO"));
        }
        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigo) {
        Optional<Item> item = this.buscar(codigo);
        if (item.isEmpty()) {
            System.out.println(("NO SE ENCONTRO ITEM A ELIMINAR"));
        } else {
            itemList.remove(item.get());
            System.out.println(("ITEM ELIMINAAO CORRECTAMENTE"));
        }
    }

    @Override
    public List mostrarTodos() {
        return itemList;
    }
}
