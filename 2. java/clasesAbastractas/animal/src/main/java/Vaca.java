public class Vaca extends Animal implements IHerbivoro{

    public Vaca(String raza) {
        super(raza);
    }

    @Override
    void emitirSonido() {
        System.out.println("Emitiendo sonido: muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo Hierva");
    }
}
