package modelo;

import interfaces.Modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class CRUD <T extends Modelo>{
    protected List<T> modelos;

    public CRUD() {
        this.modelos = new ArrayList<>();
    }

    public T obtenerPorId(String id){
        return modelos.stream().filter(modelo -> Objects.equals(modelo.getId(), id)).findFirst().orElse(null);
    }

    public void agregar(T modelo){
        if (modelos.contains(modelo)) {
            throw new RuntimeException("El modelo ya existe");
        }
        modelos.add(modelo);
    }

    public void eliminar(T modelo){
        if (!modelos.contains(modelo)) {
            throw new RuntimeException("El modelo no existe");
        }
        modelos.remove(modelo);
    }

    public void actualizar(T modelo){
        if (!modelos.contains(modelo)) {
            throw new RuntimeException("El modelo no existe");
        }
        modelos.set(modelos.indexOf(modelo), modelo);
    }

    public List<T> obtenerTodos(){
        return modelos;
    }

    @Override
    public String toString() {
        return "CRUD{" +
                "modelos=" + modelos +
                '}';
    }
}
