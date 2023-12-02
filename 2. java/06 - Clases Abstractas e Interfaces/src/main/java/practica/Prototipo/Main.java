package practica.Prototipo;

public class Main {
    public static void main(String[] args) {
        Prototipo<Float> serieFloat = new SerieProgresivaFloat();
        System.out.println("Lista de Float");
        serieFloat.crearSerieConValorInicialYAumento(2.5F,1.5F);
        for (int i = 0; i<5; i++) {
            System.out.println("Siguiente Valor: " + serieFloat.devuelveSiguienteValor());
        }

        serieFloat.reiniciarSerie();

        Prototipo<Integer> serieInt = new SerieProgresivaInteger();
        System.out.println("Lista de Integer");
        serieInt.crearSerieConValorInicialYAumento(2,2);
        for (int i = 0; i<5; i++) {
            System.out.println("Siguiente Valor: " + serieInt.devuelveSiguienteValor());
        }
    }
}
