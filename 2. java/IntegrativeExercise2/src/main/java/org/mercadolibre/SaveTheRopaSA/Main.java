package org.mercadolibre.SaveTheRopaSA;

import org.mercadolibre.SaveTheRopaSA.model.Pants;
import org.mercadolibre.SaveTheRopaSA.model.Shirt;
import org.mercadolibre.SaveTheRopaSA.model.Garment;
import org.mercadolibre.SaveTheRopaSA.model.Wardrobe;

import java.util.List;

public class Main {
    public static void main(String[] args){
        Garment shirt = new Shirt("ZARA", "Camisa Verano");
        Garment pants = new Pants("H&M", "Jeans negro");

        Wardrobe wardrobe = new Wardrobe();

        Integer key = wardrobe.saveGarment(List.of(shirt, pants));
        System.out.println("********** Guardaropas número: " + key + " **********");

        wardrobe.showGarments(null);

        Garment shirt2 = new Shirt("ZARA", "Camisa corta");
        Garment pants2 = new Shirt("ZARA", "Joggin blanco");

        Integer key2 = wardrobe.saveGarment(List.of(shirt2,pants2));
        System.out.println("********** Guardaropas número: " + key2 + " **********");
        //delete inexistent garment
        wardrobe.removeGarments(3);

        wardrobe.showGarments(1);

    }
}
