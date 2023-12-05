package Repository;

import org.example.Cliente;
import org.example.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FacturaImplementa implements CRUD <Factura>{

    List<Factura> facturas = new ArrayList<Factura>();

    @Override
    public void guardar(Factura objeto) {
        facturas.add(objeto);
    }

    @Override
    public void mostrar() {
        for (Factura factura: facturas){
            System.out.println(factura);
        }
    }

    @Override
    public Optional<Factura> buscar(int id) {
        if (facturas.stream().anyMatch(aux -> aux.getId() == id)){
            List<Factura> listaClientesFiltrada = facturas.stream()
                    .filter(aux -> aux.getId() == id)
                    .collect(Collectors.toList());
            System.out.println(listaClientesFiltrada);}
        else {
            System.out.println("Cliente no encontrado");
        }
        return Optional.empty();
    }

    @Override
    public List<Factura> buscarTods() {
        return null;
    }

    @Override
    public void eliminar(int id) {
        facturas.removeIf(aux -> aux.getId() == id);
    }

    public void getTotal(){
        double suma = 0;
        for (Factura aux:facturas
             ) {
            suma = suma + aux.getTotal();
        }
        System.out.println("El total recaudado es: " + suma);
    }
}
