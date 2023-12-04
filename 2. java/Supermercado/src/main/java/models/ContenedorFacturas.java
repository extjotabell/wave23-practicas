package models;

import factories.TipoExcepcion;
import interfaces.CRUD;

public class ContenedorFacturas extends CRUD<Factura> {

    public ContenedorFacturas() {
        super(TipoExcepcion.FACTURA_EXCEPCION);
    }

    @Override
    public void add(Factura factura){
        Supermercado supermercado = Supermercado.getInstance();
        if(!supermercado.getClientes().exists(factura.getCliente())){
            System.out.println("El cliente asociado a la factura no existe");
            System.out.println("Creandolo...");
            supermercado.getClientes().add(factura.getCliente());
        }
        super.add(factura);
    }
}
