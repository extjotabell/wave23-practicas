package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> diccionario;
    private int contador;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        diccionario.put(++contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : diccionario.entrySet()) {
            System.out.println("Número identificador: " + entry.getKey());
            for (Prenda prenda : entry.getValue()) {
                System.out.println("   Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return diccionario.getOrDefault(numero, new ArrayList<>());
    }
}
