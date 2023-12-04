package org.ejercicio.modelo;

import org.ejercicio.modelo.interfaces.IOPeraciones;

import java.util.List;

public class RegistroContable implements IOPeraciones<Factura,Long> {
    private List<Factura> facturas;

    public RegistroContable(List<Factura> facturas) {
        this.facturas = facturas;
    }
    @Override
    public boolean guardar(Factura nuevaFactura) {
        return getFacturas().add(nuevaFactura);
    }

    @Override
    public void mostrar() {
        System.out.println(this.toString());
    }

    @Override
    public boolean eliminar(Factura facturaAEliminar) {
        return facturas.remove(facturaAEliminar);
    }

    @Override
    public void actualizar(Factura facturaAActualizar) {
        getFacturas().set(getFacturas().indexOf(encontrarPorId(facturaAActualizar.getId())), facturaAActualizar);
    }

    @Override
    public Factura encontrarPorId(Long id) {
        return facturas.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "RegistroContable {" +
                "facturas=" + facturas +
                '}';
    }


}
