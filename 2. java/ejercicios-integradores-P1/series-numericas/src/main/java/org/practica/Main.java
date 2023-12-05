package org.practica;

public class Main {
    public static void main(String[] args) {
        // --- Creamos serie de tipo Integer que se incrementa en 2, con valor inicial 0 ----
        SerieIncrementoEn2 serieInteger = new SerieIncrementoEn2<Integer>(0);

        // Imprimimos primeros 4 valores
        System.out.println(serieInteger.getNextValue()); // 2
        System.out.println(serieInteger.getNextValue()); // 4
        System.out.println(serieInteger.getNextValue()); // 6
        System.out.println(serieInteger.getNextValue()); // 8

        //Reiniciamos la serie
        serieInteger.restart();
        System.out.println(serieInteger.getNextValue()); // 2

        //Seteamos un nuevo valor inicial y reiniciamos la serie
        serieInteger.setInitialValue(50);
        serieInteger.restart();

        // Imprimimos primeros 4 valores
        System.out.println(serieInteger.getNextValue()); // 52
        System.out.println(serieInteger.getNextValue()); // 54
        System.out.println(serieInteger.getNextValue()); // 56
        System.out.println(serieInteger.getNextValue()); // 58

        // ---- Creamos serie de tipo Float que se incrementa en 2, con valor inicial 0.5f ----
        SerieIncrementoEn2 serieFloat = new SerieIncrementoEn2<Float>(0.5f);

        // Imprimimos primeros 4 valores
        System.out.println(serieFloat.getNextValue()); // 2.5
        System.out.println(serieFloat.getNextValue()); // 4.5
        System.out.println(serieFloat.getNextValue()); // 6.5
        System.out.println(serieFloat.getNextValue()); // 8.5

        //Reiniciamos la serie
        serieFloat.restart();
        System.out.println(serieFloat.getNextValue()); // 2.5

        //Seteamos un nuevo valor inicial y reiniciamos la serie
        serieFloat.setInitialValue(25.5);
        serieFloat.restart();

        // Imprimimos primeros 4 valores
        System.out.println(serieFloat.getNextValue()); // 27.5
        System.out.println(serieFloat.getNextValue()); // 29.5
        System.out.println(serieFloat.getNextValue()); // 31.5
        System.out.println(serieFloat.getNextValue()); // 33.5


        // --- Creamos serie de tipo Double que se incrementa por doble, con valor inicial 10 ----
        SerieIncrementoPor2 serieDouble = new SerieIncrementoPor2<Double>(10d);

        // Imprimimos primeros 4 valores
        System.out.println(serieDouble.getNextValue()); // 20
        System.out.println(serieDouble.getNextValue()); // 40
        System.out.println(serieDouble.getNextValue()); // 80
        System.out.println(serieDouble.getNextValue()); // 160

        //Reiniciamos la serie
        serieDouble.restart();
        System.out.println(serieDouble.getNextValue()); // 20

        //Seteamos un nuevo valor inicial y reiniciamos la serie
        serieDouble.setInitialValue(50);
        serieDouble.restart();

        // Imprimimos primeros 4 valores
        System.out.println(serieDouble.getNextValue()); // 100
        System.out.println(serieDouble.getNextValue()); // 200
        System.out.println(serieDouble.getNextValue()); // 400
        System.out.println(serieDouble.getNextValue()); // 800

        // --- Creamos serie de tipo Double que se incrementa por doble, con valor inicial 10 ----
        SerieIncrementoPor2 serieLong = new SerieIncrementoPor2<Long>(21L);

        // Imprimimos primeros 4 valores
        System.out.println(serieLong.getNextValue()); // 42
        System.out.println(serieLong.getNextValue()); // 84
        System.out.println(serieLong.getNextValue()); // 168
        System.out.println(serieLong.getNextValue()); // 336

        //Reiniciamos la serie
        serieLong.restart();
        System.out.println(serieLong.getNextValue()); // 42

        //Seteamos un nuevo valor inicial y reiniciamos la serie
        serieLong.setInitialValue(39L);
        serieLong.restart();

        // Imprimimos primeros 4 valores
        System.out.println(serieLong.getNextValue()); // 78
        System.out.println(serieLong.getNextValue()); // 156
        System.out.println(serieLong.getNextValue()); // 312
        System.out.println(serieLong.getNextValue()); // 624


    }
}