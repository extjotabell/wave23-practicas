package practica.Imprenta;

public class Curriculum  extends Documento {

    private Persona p;

    public Curriculum(Persona p) {
        this.p = p;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum...");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Curriculum:\n" +
                "Persona:\n" + p;
    }


}
