import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Curriculum imprimible
        Curriculum curriculum = new Curriculum(
            "Emmanuel",
            "López",
            "12345678",
            21,
            Arrays.asList("Java", "JavaScript", "MySQL", "REST APIs", "Git", "Python")
        );

        curriculum.imprimir();

        // Libro imprimible
        System.out.println();

        LibroPDF libro = new LibroPDF(
            "Novela",
            1000,
            "Miguel de Cervantes",
            "Don Quijote de la Mancha"
        );

        libro.imprimir();

        // Informe impimible
        System.out.println();

        Informe informe = new Informe(
            "Semana 1 IT Bootcamp",
            4,
            "Emmanuel López",
            "Pepito Pérez"
        );

        informe.imprimir();
    }
}
