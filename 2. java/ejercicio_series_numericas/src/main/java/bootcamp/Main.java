package bootcamp;

public class Main {
    public static void main(String[] args) {
        SerieSumadora serie1 = new SerieSumadora(2, 1);
        serie1.siguiente();
        System.out.println(serie1.siguiente());
        serie1.reiniciar();
        System.out.println(serie1.siguiente());
        serie1.estableceInicio(1000);
        System.out.println(serie1.siguiente());

        SerieMultiplicadora serie2 = new SerieMultiplicadora(-2.0, -1.0);
        serie2.siguiente();
        System.out.println(serie2.siguiente());
        serie2.reiniciar();
        System.out.println(serie2.siguiente());
        serie2.estableceInicio(2);
        System.out.println(serie2.siguiente());
    }
}