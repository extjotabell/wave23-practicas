package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------- Escenary Integer ---------");
        EscenaryTwo escenaryTwo = new EscenaryTwo();
        escenaryTwo.setNumberNextProgresive(2);
        System.out.println(escenaryTwo.getNumberNextProgressive());
        System.out.println(escenaryTwo.getNumberNextProgressive());
        System.out.println(escenaryTwo.getNumberNextProgressive());
        System.out.println(escenaryTwo.getNumberNextProgressive());

        System.out.println("--------- Escenary Double ---------");
        EscenaryThree escenaryThree = new EscenaryThree();
        escenaryThree.setNumberNextProgresive(3.3);
        System.out.println(escenaryThree.getNumberNextProgressive());
        System.out.println(escenaryThree.getNumberNextProgressive());
        System.out.println(escenaryThree.getNumberNextProgressive());
        System.out.println(escenaryThree.getNumberNextProgressive());
        System.out.println("--------- Escenary Double Whit New Progresive ---------");
        escenaryThree.setNumberNextProgresive(1.1);
        System.out.println(escenaryThree.getNumberNextProgressive());
        System.out.println(escenaryThree.getNumberNextProgressive());
        System.out.println(escenaryThree.getNumberNextProgressive());

    }
}