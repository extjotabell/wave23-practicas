package org.ejercicio.modelo;

import java.util.List;

public class RegistroContable {
    private List<Factura> facturas;

    public RegistroContable(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public void agregarFactura(Factura nuevaFactura){
        this.getFacturas().add(nuevaFactura);
    }

    @Override
    public String toString() {
        return "RegistroContable {" +
                "facturas=" + facturas +
                '}';
    }
}
