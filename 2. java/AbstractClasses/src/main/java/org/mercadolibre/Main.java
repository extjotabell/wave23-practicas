package org.mercadolibre;

import org.mercadolibre.model.SeriesOfThree;
import org.mercadolibre.model.SeriesOfTwo;

public class Main {
    public static void main(String[] args) {
        SeriesOfTwo seriesOfTwo = new SeriesOfTwo();
        SeriesOfThree seriesOfThree = new SeriesOfThree();

        System.out.println("********** Serie de dos iniciada **********");
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor siguiente: " + seriesOfTwo.nextValue());
        }

        seriesOfTwo.restartSeries();

        System.out.println("********** Serie de dos reiniciada **********");
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor siguiente: " + seriesOfTwo.nextValue());
        }

        System.out.println("********** Serie de tres iniciada **********");
        seriesOfThree.setInitialValue(1);
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor siguiente: " + seriesOfThree.nextValue());
        }
    }
}