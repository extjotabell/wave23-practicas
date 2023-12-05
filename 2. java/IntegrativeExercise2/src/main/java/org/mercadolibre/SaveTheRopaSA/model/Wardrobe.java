package org.mercadolibre.SaveTheRopaSA.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {
    Map<Integer, List<Garment>> garments;
    private Integer index;

    public Wardrobe() {
        this.garments = new HashMap<>();
        this.index = 0;
    }

    public Wardrobe(Map<Integer, List<Garment>> garments) {
        this.garments = garments;
        this.index = 0;
    }

    public void showGarments(Integer number) {
        garments.entrySet().stream()
                .filter(entry -> number == null || entry.getKey().equals(number))
                .forEach(entry -> {
                    System.out.println("Detalles de prendas guardada: ");
                    entry.getValue().forEach(garment -> System.out.println(garment.toString()));
                });
    }

    public Integer saveGarment(List<Garment> garments){
        Integer number = getIndex();
        this.garments.put(getIndex(), garments);
        this.setIndex(this.index + 1);
        return number;

    }

    public void removeGarments(Integer index){
        try {
            this.garments.remove(index);
        }catch (Exception e){
            this.garments.remove(index);
        }
    }

    public Integer getIndex(){
        return index + 1;
    }

    public void setIndex(Integer index){
        this.index = index;
    }

    public Map<Integer, List<Garment>> getGarments() {
        return garments;
    }

    public void setGarments(Map<Integer, List<Garment>> garments) {
        this.garments = garments;
    }
}
