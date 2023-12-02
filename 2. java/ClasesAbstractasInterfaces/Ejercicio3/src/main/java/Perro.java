public class Perro extends Animal implements ICarnivoro{
    @Override
    void emitirSonido() {
        System.out.println("Guauuuu");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro esta comiendo carne...");
    }
}
