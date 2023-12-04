package org.practica;

import java.util.ArrayList;
import java.util.List;

public class FacturaRepositorio {
    private static FacturaRepositorio instancia;
    private List<Factura> facturas;

    private FacturaRepositorio(){
        facturas = new ArrayList<>();
    }
    public static FacturaRepositorio getInstancia() {
        if (instancia == null) {
            instancia = new FacturaRepositorio();
        }
        return instancia;
    }

    public void addFactura(Factura factura, ClienteRepositorio repoClientes) {
        if(!repoClientes.tieneCliente(factura.getCliente())){
            repoClientes.addCliente(factura.getCliente());
        }
        facturas.add(factura);
    }

    public List<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }

}
