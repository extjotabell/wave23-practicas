package bootcamp;

public class Main {
    public static void main(String[] args) {
        //Explanaitions of changes:
        /*
        Either solution is in general a bad idea, is better to use one concrete type,
        like BigDecimal or Double and based on those operations implement the Prototype.
         */
        SerieSumadora<Integer> serie1 = new SerieSumadora<>(2, 1);
        serie1.siguiente();
        System.out.println(serie1.siguiente());
        serie1.reiniciar();
        System.out.println(serie1.siguiente());
        serie1.estableceInicio(1000);
        System.out.println(serie1.siguiente());

        SerieMultiplicadora<Double> serie2 = new SerieMultiplicadora<>(-2.0, -1.0);
        serie2.siguiente();
        System.out.println(serie2.siguiente());
        serie2.reiniciar();
        System.out.println(serie2.siguiente());
        serie2.estableceInicio(2.0);
        System.out.println(serie2.siguiente());
    }
}