package org.example;

public class Main {
    public static void main(String[] args) {
        SerieDos serieDos = new SerieDos();
        SerieTres serieTres = new SerieTres();

        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor: " + serieDos.siguienteNumSerie());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("Siguiente valor: " + serieTres.siguienteNumSerie());
        }
    }
}