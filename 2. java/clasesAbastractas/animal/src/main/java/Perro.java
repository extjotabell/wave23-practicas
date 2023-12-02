public class Perro extends Animal implements ICarnivoro {
    public Perro(String raza) {
        super(raza);
    }

    @Override
    void emitirSonido() {
        System.out.println("Emitiendo sonido: guau");
    }


    @Override
    public void comerCarne() {
        System.out.println("Comiendo Carne");
    }
}
