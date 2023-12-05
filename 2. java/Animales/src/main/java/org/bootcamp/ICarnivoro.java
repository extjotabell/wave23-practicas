package org.bootcamp;

public interface ICarnivoro {

    default void comerCarne(){
        System.out.println("Comiendo Carne");
    }

}
