package org.example;

public class Main {
    public static void main(String[] args) {
        SerieDeDos serieDeDos = new SerieDeDos(0);
        SerieDeTres serieDeTres = new SerieDeTres(0);

        System.out.println("Serie de dos");
        System.out.println(serieDeDos.getValorActual());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        serieDeDos.resetValorInicial(1);
        System.out.println("Seteo valor inicial a 1 para serie de 2");
        System.out.println(serieDeDos.getValorActual());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());
        System.out.println(serieDeDos.getSiguienteValor());

        System.out.println();

        System.out.println("Serie de tres");
        System.out.println(serieDeTres.getValorActual());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        serieDeTres.resetValorInicial(1);
        System.out.println("Seteo valor inicial a 1 para serie de 3");
        System.out.println(serieDeTres.getValorActual());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());
        System.out.println(serieDeTres.getSiguienteValor());

    }
}