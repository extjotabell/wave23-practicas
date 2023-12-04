package org.example;

import org.example.prendas.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        this.prendas.put(++id, prendas);
        return id;
    }

    public void mostrarPrendas() {
        prendas.forEach((key, value) -> System.out.printf("%d: %s\n", key, value));
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return prendas.get(id);
    }
}
