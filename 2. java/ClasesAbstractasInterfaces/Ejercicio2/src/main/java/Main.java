import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ImprimibleImpl imprimible = new ImprimibleImpl();
        List<String> habilities = Arrays.asList("Comunicacion","Trabajo en equipo");
        Persona p = new Persona("Geronimo","Schmidt",24, habilities);
        List<Persona> personas = Arrays.asList(p);

        Curriculum curriculum = new Curriculum(personas);
        Informes informes = new Informes();
        LibrosPDF librosPDF = new LibrosPDF();

        imprimible.imprimir(librosPDF);
        imprimible.imprimir(curriculum);
        imprimible.imprimir(informes);

    }
}
