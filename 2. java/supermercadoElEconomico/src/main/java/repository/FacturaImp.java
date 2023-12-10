package repository;

import model.Cliente;
import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FacturaImp implements CRUD<Factura> {
    private List<Factura> listaFacturas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    private double calcularTotalCompra(List<Item> items) {
        return items.stream().mapToDouble(item -> item.getCantidadComprada() * item.getCostoUnitario()).sum();
    }

    @Override
    public void agregar(Factura factura) {
        listaFacturas.add(factura);
    }

    @Override
    public void eliminar(Factura factura) {
        listaFacturas.remove(factura);
    }

    @Override
    public void actualizar(Factura facturaVieja, Factura facturaNueva) {
        int index = listaFacturas.indexOf(facturaVieja);
        if (index != -1) {
            listaFacturas.set(index, facturaNueva);
        }
    }

    @Override
    public Factura consultar(String criterio) {
        for (Factura factura : listaFacturas) {
            if (String.valueOf(factura.getCliente().getDni()).equals(criterio)) {
                return factura;
            }
        }
        return null;
    }

    @Override
    public void obtenerTodos() {

    }

    public void crearFactura(int dniCliente){
        ItemImp item = new ItemImp();
        ClienteImp cliente = new ClienteImp();
        Factura factura = new Factura();


        System.out.print("Ingrese la cantidad de ítems a agregar a la factura: ");
        int cantidadItems = sc.nextInt();


       factura.setTotalCompra(item.agregarItem(cantidadItems));
        System.out.println("Total de la factura: " + factura);

    }


}
