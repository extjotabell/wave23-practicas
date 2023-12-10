package repository;

import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItemImp implements CRUD<Item>{

    List<Item> listaItem = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void agregar(Item item) {
          listaItem.add(item);
    }


    @Override
    public void eliminar(Item item) {
        listaItem.remove(item);
    }

    @Override
    public void actualizar(Item itemViejo, Item itemNuevo) {
        int index = listaItem.indexOf(itemViejo);
        if (index != -1) {
            listaItem.set(index, itemNuevo);
        }
    }

    @Override
    public Item consultar(String criterio) {
        for (Item item : listaItem) {
            if (item.getCodigoProducto().equals(criterio)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void obtenerTodos() {
        listaItem.forEach(items -> {
            System.out.print("Código producto: " + items.getCodigoProducto());
            System.out.print(" |-| Nombre del producto: " + items.getNombreProducto());
            System.out.print(" |-| Costo unitario: " + items.getCostoUnitario());
            System.out.print(" |-| Cantidad Comprada: " + items.getCantidadComprada() + "\n");
        });
    }

    public double agregarItem(int cantidadItems){
        double totalItem = 0.0;
        for (int i = 0; i < cantidadItems; i++) {
            System.out.println("Ingrese los detalles del ítem " + (i + 1) + ":");
            System.out.print("Código del producto: ");
            String codigoProducto = sc.next();
            System.out.print("Nombre del producto: ");
            String nombreProducto = sc.next();
            System.out.print("Cantidad comprada: ");
            int cantidadComprada = sc.nextInt();
            System.out.print("Costo unitario: ");
            double costoUnitario = sc.nextDouble();

            double calcularCompra = cantidadComprada * costoUnitario;
            totalItem +=calcularCompra;
            Item item = new Item(codigoProducto, nombreProducto, cantidadComprada, costoUnitario);
            agregar(item);
        }
        obtenerTodos();
        return totalItem;
    }


}
