package main;

public class Main {
    public static void main(String[] args) {

        // Prueba Integer
        /*Prototipo<Integer> protInt = new SerieInteger(1);
        System.out.println("Serie Integer:");
        System.out.println(protInt.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protInt.getProxNumeroSerie());
        }
        System.out.println();

        System.out.println("Seteo de valor inicial en 3");
        protInt.setValorInicialSerie(3);
        System.out.println(protInt.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protInt.getProxNumeroSerie());
        }
        System.out.println();

        System.out.println("Reinicio serie");
        protInt.reiniciarSerie();
        System.out.println(protInt.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protInt.getProxNumeroSerie());
        }
        System.out.println();*/


        // Prueba Double
        /*Prototipo<Double> protDouble = new SerieDouble(3d);
        System.out.println("Serie Double:");
        System.out.println(protDouble.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protDouble.getProxNumeroSerie());
        }
        System.out.println();

        System.out.println("Seteo de valor inicial en 1");
        protDouble.setValorInicialSerie(1d);
        System.out.println(protDouble.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protDouble.getProxNumeroSerie());
        }
        System.out.println();

        System.out.println("Reinicio serie");
        protDouble.reiniciarSerie();
        System.out.println(protDouble.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protDouble.getProxNumeroSerie());
        }
        System.out.println();*/


        // Prueba Float
        Prototipo<Float> protFloat = new SerieFloat(2f);
        System.out.println("Serie Float:");
        System.out.println(protFloat.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protFloat.getProxNumeroSerie());
        }
        System.out.println();

        System.out.println("Seteo de valor inicial en 3");
        protFloat.setValorInicialSerie(3f);
        System.out.println(protFloat.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protFloat.getProxNumeroSerie());
        }
        System.out.println();

        System.out.println("Reinicio serie");
        protFloat.reiniciarSerie();
        System.out.println(protFloat.valorActual);
        for (int i = 0; i <= 4; i++) {
            System.out.println(protFloat.getProxNumeroSerie());
        }
        System.out.println();
    }
}
