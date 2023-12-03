package Ejercicio3;

public class Vaca extends Animal implements IHerviboro{
    @Override
    void emitirSonidos() {
        System.out.println("Muuu");
    }
}
