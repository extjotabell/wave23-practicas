public class Main {
    public static void main(String[] args) {
        SerieInt serie = new SerieInt(2, 2);
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        serie.setInicio(1);
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());

        System.out.println("----------");

        SerieDouble serie2 = new SerieDouble(3.0, 4.0);
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
        serie2.setInicio(10.0);
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
        System.out.println(serie2.siguiente());
    }
}
