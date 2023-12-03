// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Serie Integer");
        SerieInteger serieIntegerTwo = new SerieInteger(0,2);
        System.out.println(serieIntegerTwo.next());
        System.out.println(serieIntegerTwo.next());
        System.out.println(serieIntegerTwo.next());
        System.out.println(serieIntegerTwo.next());

        System.out.println();
        // Cambio el valor inicial a 1
        serieIntegerTwo.setValue(1);
        System.out.println(serieIntegerTwo.next());
        System.out.println(serieIntegerTwo.next());
        System.out.println(serieIntegerTwo.next());
        System.out.println(serieIntegerTwo.next());

        System.out.println();
        // Cambio a serie de 3
        SerieInteger serieIntegerThree = new SerieInteger(0, 3);
        System.out.println(serieIntegerThree.next());
        System.out.println(serieIntegerThree.next());
        System.out.println(serieIntegerThree.next());
        System.out.println(serieIntegerThree.next());

        System.out.println();
        System.out.println("Serie Double");
        SerieDlouble serieDloubleTwo = new SerieDlouble(0.0,2.0);
        System.out.println(serieDloubleTwo.next());
        System.out.println(serieDloubleTwo.next());
        System.out.println(serieDloubleTwo.next());
        System.out.println(serieDloubleTwo.next());

        System.out.println();
        // Cambio el valor inicial a 1
        serieDloubleTwo.setValue(1.1);
        System.out.println(serieDloubleTwo.next());
        System.out.println(serieDloubleTwo.next());
        System.out.println(serieDloubleTwo.next());
        System.out.println(serieDloubleTwo.next());

        System.out.println();
        // Cambio a serie de 3
        SerieDlouble serieDloubleThree = new SerieDlouble(0.0, 3.0);
        System.out.println(serieDloubleThree.next());
        System.out.println(serieDloubleThree.next());
        System.out.println(serieDloubleThree.next());
        System.out.println(serieDloubleThree.next());
    }
}