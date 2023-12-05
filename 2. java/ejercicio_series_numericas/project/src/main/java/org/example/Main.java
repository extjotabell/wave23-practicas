package org.example;

public class Main {
    public static void main(String[] args) {
        // EJEMPLO DE SERIE DE 2
        Serie2 serie_2 = new Serie2();

        serie_2.nextValue();
        serie_2.nextValue();

        serie_2.resetValue();
        serie_2.setValue(6);
        serie_2.nextValue();

        // EJEMPLO DE SERIE DE 3
        Serie3 serie_3 = new Serie3();

        serie_3.nextValue();
        serie_3.nextValue();

        serie_3.resetValue();
        serie_3.setValue(10);
        serie_3.nextValue();
    }
}