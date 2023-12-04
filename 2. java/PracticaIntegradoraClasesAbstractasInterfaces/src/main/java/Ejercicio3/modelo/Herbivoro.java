package org.example.modelo;

public interface Herbivoro {
    default void comerHierba(){
        System.out.println("Comiendo hierba");
    }
}
