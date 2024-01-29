import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda p1 = new Prenda("Nike", "Air Force");
        Prenda p2 = new Prenda("Vans", "Clasica");
        System.out.println("Se han guardado las prendas con el ID = " + guardaRopa.guardarPrendas(List.of(p1,p2)));
    }
}