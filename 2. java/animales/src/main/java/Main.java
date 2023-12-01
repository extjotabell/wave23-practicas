import java.util.List;
import animales.*;

public class Main {
    public static void main(String[] args) {
        List<Animal> animales = List.of(
            new Perro(),
            new Gato(),
            new Vaca()
        );

        for (Animal animal : animales) {
            System.out.println("--------------- " + animal + " ---------------");

            animal.hacerSonido();
            animal.comer();
        }
    }
}
