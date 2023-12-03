package Ejercicio3;

public class Gato extends Animal implements ICarnivoro{
    @Override
    void emitirSonidos() {
        System.out.println("Miau");
    }


}
