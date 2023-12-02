public class Main {
    public static void main(String[] args) {
        Prueba2 prueba2 = new Prueba2();
        Prueba1 prueba1 = new Prueba1();

        System.out.println("Start: "+ prueba2.start(2));
        System.out.println("Next: "+ prueba2.returnNextNumber());
        System.out.println("Next: "+ prueba2.returnNextNumber());
        System.out.println("Next: "+ prueba2.returnNextNumber());
        System.out.println("Restore: "+prueba2.restore());
        System.out.println("Start: "+ prueba1.start(3));
        System.out.println("Next: "+ prueba1.returnNextNumber());
        System.out.println("Next: "+ prueba1.returnNextNumber());
        System.out.println("Next: "+ prueba1.returnNextNumber());
        System.out.println("Restore: "+prueba1.restore());


    }
}
