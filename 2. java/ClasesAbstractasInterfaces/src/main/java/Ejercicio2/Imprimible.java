package Ejercicio2;

public interface Imprimible {
    default void imprimir(){
        System.out.println(this);
    }
}