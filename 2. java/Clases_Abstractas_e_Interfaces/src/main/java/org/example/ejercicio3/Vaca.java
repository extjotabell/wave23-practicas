package org.example.ejercicio3;

public class Vaca extends Animal implements Herviboro {
    @Override
    public void comerHierba() {
        System.out.println("Como hierba");
    }

    @Override
    public void emitirSonido(){
        super.emitirSonido();
        System.out.println("Muuu!");
    }
}
