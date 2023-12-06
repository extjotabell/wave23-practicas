package org.example;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorImple implements Calculando <Localizador> {
    List<Localizador> localizadors = new ArrayList<Localizador>();

    @Override
    public void addLista(Localizador objeto) {
        localizadors.add(objeto);
    }

    @Override
    public String toString() {
        return "LocalizadorImple{" +
                "localizadors=" + localizadors +
                '}';
    }
}
