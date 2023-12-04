package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador = 0;

    private HashMap<Integer,List<Prenda>> diccionario;

    public GuardaRopa() {
        this.diccionario = new HashMap<>();
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        this.contador++;
        diccionario.put(contador,listaDePrendas);
        return contador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> ropa:diccionario.entrySet()
             ) {
            System.out.println("El id: "+ropa.getKey() + " tiene la siguiente ropa: "+ropa.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        System.out.println("La ropa a devolver es:");
        List<Prenda> aux = diccionario.get(numero);
        diccionario.remove(numero);
        return aux;

    }


}
