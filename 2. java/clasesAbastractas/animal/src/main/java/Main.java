import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {

        Perro poodle = new Perro("Poodle");
        Perro rottweiler = new Perro("Rottweiler");
        Gato bengal = new Gato("Bengal");
        Gato birmano = new Gato("Birmano");
        Vaca brangus = new Vaca("Brangus");
        Vaca bradford = new Vaca("Bradford");

        System.out.println("-----Perros----");

        System.out.println("Raza:" + poodle.raza);
        poodle.emitirSonido();
        poodle.comerCarne();

        System.out.println("\nRaza:" + rottweiler.raza);
        rottweiler.emitirSonido();
        rottweiler.comerCarne();

        System.out.println("\n-----Gatos----");

        System.out.println("\nRaza:" +bengal.raza);
        bengal.emitirSonido();
        bengal.comerCarne();


        System.out.println("\nRaza:" +birmano.raza);
        birmano.emitirSonido();
        birmano.comerCarne();

        System.out.println("\n-----Vacas----");

        System.out.println("\nRaza:" +brangus.raza);
        brangus.emitirSonido();
        brangus.comerHierba();

        System.out.println("\nRaza:" +bradford.raza);
        bradford.emitirSonido();
        bradford.comerHierba();
    }
}
