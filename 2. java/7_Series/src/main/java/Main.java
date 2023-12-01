public class Main {

    private static void mostrarSerie(Serie serie, int numeroIteraciones){
        for(int i = 1; i <= numeroIteraciones; i++){
            System.out.printf("Valor %d : %d%n", i, serie.calcularSiguiente());
        }
    }

    public static void main(String[] args) {

        int aumento = 5;
        int multiplicador = 7;

        SerieSuma serieSuma = new SerieSuma(0, aumento);
        SerieMultiplicacion serieMultiplicacion = new SerieMultiplicacion(1, multiplicador);

        int numeroIteraciones = 5;

        System.out.println("SERIE DE SUMA");
        System.out.printf("Mostrando los primeros %d valores empezando de 0\n", numeroIteraciones);
        mostrarSerie(serieSuma, numeroIteraciones);

        int nuevoInicio = 8;
        serieSuma.establecerInicio(nuevoInicio);
        serieSuma.reiniciarSerie();
        System.out.printf("Cambiando el inicio a %d y reiniciando\n", nuevoInicio);
        mostrarSerie(serieSuma, numeroIteraciones);

        System.out.println("SERIE DE MULTIPLICACION");

        System.out.printf("Mostrando los primeros %d valores empezando de 1\n", numeroIteraciones);
        mostrarSerie(serieMultiplicacion, numeroIteraciones);

        nuevoInicio = 2;
        serieMultiplicacion.establecerInicio(nuevoInicio);
        serieMultiplicacion.reiniciarSerie();
        System.out.printf("Cambiando el inicio a %d y reiniciando\n", nuevoInicio);
        mostrarSerie(serieMultiplicacion, numeroIteraciones);


    }
}
