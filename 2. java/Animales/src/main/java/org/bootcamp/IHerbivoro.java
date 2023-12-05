package org.bootcamp;

public interface IHerbivoro {

    default void comerHierba(){
        System.out.println("Comiendo Hierba");
    }

}
