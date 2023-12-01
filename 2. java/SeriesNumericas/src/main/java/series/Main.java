package series;

public class Main {

    public static void main(String[] args) {
        SerieDeDos serie2 = new SerieDeDos();
        System.out.println("Serie de a dos");
        serie2.siguienteValor();
        serie2.siguienteValor();
        serie2.siguienteValor();

        serie2.valorInicial(4.0);

        serie2.reiniciarSerie();
        serie2.siguienteValor();
        serie2.siguienteValor();

        SerieDeTres serie3 = new SerieDeTres();
        System.out.println("\nSerie de a tres");
        serie3.siguienteValor();
        serie3.siguienteValor();
        serie3.siguienteValor();

        serie3.valorInicial(4.0);

        serie3.reiniciarSerie();
        serie3.siguienteValor();
        serie3.siguienteValor();
    }
}
