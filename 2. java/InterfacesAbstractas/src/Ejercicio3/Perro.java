package Ejercicio3;

public class Perro extends Animal implements ICarnivoro{
    @Override
    void emitirSonidos() {
        System.out.println("Guau");
    }

}
