public class Main {

    public static void imprimirDocumento (Imprimible imprimible){
        imprimible.imprimir();
    }

    public static void main(String[] args) {

        ImprimibleImpl imprimible = new ImprimibleImpl();

        Persona persona = new Persona();
        persona.nombre = "Raul";
        persona.apellido = "Lanz";
        persona.email = "lraul@email.com";
        persona.habilidades.add("Java");
        persona.habilidades.add("Spring");

        Curriculum curriculum = new Curriculum(persona);

        Informe informe = new Informe("Lorem Ipsum", 1, "Anónimo", "Mike Spike");
        LibrosPDF libros = new LibrosPDF(600, "Jhon Karzenbach", "El Psicoanalista", "Thriller");

        System.out.println("Curriculum");
          imprimirDocumento(curriculum);
        System.out.println();

        System.out.println("Informe");
          imprimirDocumento(informe);
        System.out.println();

        System.out.println("Libros");
         imprimirDocumento(libros);
        System.out.println();

    }
}
