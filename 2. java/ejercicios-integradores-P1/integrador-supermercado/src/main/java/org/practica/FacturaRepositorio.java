package org.practica;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaRepositorio implements Repositorio<Factura>{
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

    public void createFacturaAndValidate(Factura factura, ClienteRepositorio repoClientes) {
        if(!repoClientes.tieneCliente(factura.getCliente())){
            repoClientes.create(factura.getCliente());
        }
        this.create(factura);
    }

    public List<Factura> getFacturas() {
        return new ArrayList<>(facturas);
    }

    @Override
    public void create(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public void remove(Factura factura) {
        Optional<Factura> facturaOpt = facturas.stream().filter(f -> f.getCodigo() == factura.getCodigo()).findFirst();
        facturaOpt.ifPresent(value -> facturas.remove(value));
        if(facturaOpt.isEmpty())
            System.out.println("No se encontró la Factura.");
    }

    @Override
    public void update(Factura factura) {
        Optional<Factura> facturaOpt = facturas.stream().filter(f -> f.getCodigo() == factura.getCodigo()).findFirst();
        facturaOpt.ifPresent(value -> value = factura);
        if(facturaOpt.isEmpty())
            System.out.println("No se encontró la Factura.");
    }

    @Override
    public Factura getById(int codigo) {
        Optional<Factura> facturaOpt = facturas.stream().filter(f -> f.getCodigo() == codigo).findFirst();
        return facturaOpt.orElse(null);
    }
}
