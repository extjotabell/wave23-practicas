package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonidos();
        perro.comerCarne();
        perro.comerAnimal(gato);

        gato.emitirSonidos();
        gato.comerCarne();
        gato.comerAnimal(perro);

        vaca.emitirSonidos();
        vaca.comerHierbas();

    }
}
