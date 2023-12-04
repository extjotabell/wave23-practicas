package interfaces;

import Exceptions.ElementNotFoundException;
import factories.FactoryException;
import factories.TipoExcepcion;

import java.util.ArrayList;
import java.util.List;

public abstract class CRUD<T extends Model>{
    private TipoExcepcion tipo;


    List<T> models;
    public CRUD(TipoExcepcion tipo) {
        models=new ArrayList<>();
    }
    public T getById(String id) throws ElementNotFoundException{
        return models.stream().filter(model -> model.getId().equalsIgnoreCase(id))
                .findFirst().orElseThrow(()->FactoryException.createException(tipo, id));
    }

    public boolean delete(String id) {
        try {
            T factura = getById(id);
            return models.remove(factura);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void add(T element) {
        if (models.contains(element)) {
            System.out.println("La factura ya se encuentra registrada");
        } else {
            models.add(element);
            System.out.println("Se ha registrada la factura correctamente");
        }
    }

    public void showAll() {
        System.out.println("\nMostrando models:");
        models.forEach(System.out::println);
        System.out.println();
    }

    public void showById(String id) {
        try {
            T factura = getById(id);
            System.out.println(factura);
        } catch (ElementNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }



}
