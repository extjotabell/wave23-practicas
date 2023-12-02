public class Vaca extends Animal implements IHerviboro{
    @Override
    void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca esta comiendo hierba...");
    }
}
