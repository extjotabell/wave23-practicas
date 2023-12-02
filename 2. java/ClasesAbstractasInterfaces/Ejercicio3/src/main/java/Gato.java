public class Gato extends Animal implements ICarnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Miauuuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato esta comiendo carne...");
    }
}
