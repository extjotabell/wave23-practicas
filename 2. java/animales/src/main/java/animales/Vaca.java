package animales;

public class Vaca extends Animal implements IHervivoro {
    @Override
    public void hacerSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public String toString() {
        return "Vaca";
    }
}
