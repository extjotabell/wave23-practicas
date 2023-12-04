package repository;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;

public class FacturaCRUD implements CRUDRepository<Factura> {

    List<Factura> facturas = new ArrayList<>();

    @Override
    public void create(Factura obj) {
        facturas.add(obj);
    }

    @Override
    public Factura read(int id) {
        return facturas.stream()
            .filter(f -> f.getId() == id)
            .findFirst()
            .orElse(null);
    }

    @Override
    public List<Factura> readAll() {
        return facturas;
    }

    @Override
    public void update(int id, Factura obj) {
        Factura factura = read(id);

        factura.setCliente(obj.getCliente());
        factura.setItems(obj.getItems());
    }

    @Override
    public void delete(int id) {
        facturas.removeIf(f -> f.getCliente().getDni() == id);
    }
}
