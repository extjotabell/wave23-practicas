import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        Integer id1 = guardaRopa.guardarPrendas(List.of(
            new Prenda("Nike", "Air Force One"),
            new Prenda("Jordan Air", "Retro 4")
        ));

        System.out.println("Codigo del guardarropa: " + id1);

        System.out.println("\nPrendas guardadas: ");
        guardaRopa.mostrarPrendas();

        Integer id2 = guardaRopa.guardarPrendas(List.of(
            new Prenda("Adidas", "Forum 84"),
            new Prenda("New Balance", "550"),
            new Prenda("Nike", "Blazer Mid")
        ));

        System.out.println("\nCodigo del guardarropa: " + id2);

        System.out.println("\nPrendas guardadas: ");
        guardaRopa.mostrarPrendas();

        System.out.println("\nPrendas devueltas: ");
        guardaRopa.devolverPrendas(id1).forEach(p -> System.out.println("- " + p));
    }
}
