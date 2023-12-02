public class Gato extends Animal implements ICarnivoro{
    public Gato(String raza) {
        super(raza);
    }

    @Override
    void emitirSonido() {
        System.out.println("Emitiendo sonido: miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }
}
