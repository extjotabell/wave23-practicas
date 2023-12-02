package practica.Animal;

public class Main {
    public static void main(String[] args) {
        Animal perro = new Perro();
        Animal gato = new Gato();
        Animal vaca = new Vaca();

        perro.comer();
        perro.emitirSonido();

        System.out.println();

        gato.comer();
        gato.emitirSonido();

        System.out.println();

        vaca.comer();
        vaca.emitirSonido();
    }
}
