package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Herviboro vaca = new Vaca();
        Carnivoro gato = new Gato();
        Carnivoro perro = new Perro();

        vaca.comerHierba();
        gato.comerCarne();
        perro.comerCarne();
        gato.comerAnimal((Animal) vaca);
        perro.comerAnimal((Animal) gato);

    }
}
