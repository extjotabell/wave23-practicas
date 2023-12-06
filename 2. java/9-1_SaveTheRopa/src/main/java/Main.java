import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Tommy","Polera");
        Prenda prenda2 = new Prenda("quicksilver","pantalones");

        List<Prenda> miRopa = new ArrayList<>();
        List<Prenda> miRopa2 = new ArrayList<>();

        miRopa.add(prenda1);
        miRopa.add(prenda2);

        miRopa2.add(prenda2);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(miRopa);
        guardaRopa.guardarPrendas(miRopa2);

        //GuardaRopa guardaRopa1 = new GuardaRopa();

        //guardaRopa1.guardarPrendas(miRopa2);

        //guardaRopa1.mostrarPrendas();

        guardaRopa.mostrarPrendas();
        guardaRopa.devolverPrendas(1);
        guardaRopa.mostrarPrendas();
    }
}