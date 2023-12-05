package org.ejercicio.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private static Integer index;

    public GuardaRopa() {
        prendas = new HashMap<>();
        this.index = 0;
    }

    public GuardaRopa(Map<Integer, List<Prenda>> prendas) {

        this.prendas = prendas;
        this.index = 0;
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }


    public Integer getIndex() {
        return index + 1;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer guardarRopa(List<Prenda> listaPrendas){
        this.prendas.put(getIndex(),listaPrendas);
        this.setIndex(index+1);
        return index;
    }

    public void mostrarPrendas(){
        prendas.keySet().forEach((key)->{
            System.out.println("Elemento de id: " + key);
            for(Prenda prenda: prendas.get(key)){
                System.out.println(prenda);
            };
        });

    }

    public List<Prenda> devolverPrendas(Integer index) throws Exception {
        if (prendas.keySet().contains(index)) return prendas.remove(index);
        else throw new ExcepcionGuardaRopa("No existe una lista de prendas con ese identificador");
    }
}
