package animales;

public class Perro extends Animal implements ICarnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public String toString() {
        return "Perro";
    }
}
