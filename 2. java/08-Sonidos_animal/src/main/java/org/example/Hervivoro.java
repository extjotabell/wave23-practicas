package org.example;

public interface Hervivoro {
    default void comerHierba(){
        System.out.println("Comiendo pasto");
    }

    void emitirSonido();
}