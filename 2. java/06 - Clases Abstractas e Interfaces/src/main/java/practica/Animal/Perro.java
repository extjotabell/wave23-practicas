package practica.Animal;

public class Perro extends Animal implements Carnívoro {

    @Override
    public void emitirSonido() {
        System.out.println("GUAU");
    }

    @Override
    public void comer() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El " + this.getClass().getSimpleName().toLowerCase() + " come carne");
    }
}
