public class Main {

    public static void main(String[] args) {

        Documento informe = new Informe("Texto de prueba", 10, "Pedro", "José");
        Curriculum cv = new Curriculum("Juan", "Pérez", "12345", 30);
        cv.agregarHabilidad("Leer");
        Documento pdf = new LibroPDF("Suspenso", 50, "María", "El libro");

        Imprimible.imprimirDocumento(informe);
        Imprimible.imprimirDocumento(cv);
        Imprimible.imprimirDocumento(pdf);

    }

}
