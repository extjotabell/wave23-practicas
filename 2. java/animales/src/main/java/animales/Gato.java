package animales;

public class Gato extends Animal implements ICarnivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public String toString() {
        return "Gato";
    }
}
