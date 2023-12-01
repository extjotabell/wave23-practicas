package org.example;

public class Main {

    public static String comerAnimal(Animal animal){
        if(animal instanceof IHervivoro){
            return ((IHervivoro) animal).comerHierva();
        }else if(animal instanceof ICarnivoro){
            return ((ICarnivoro) animal).comerCarne();
        }else{
            return "Desconocido";
        }
    }

    public static void main(String[] args) {
        Vaca vaca = new Vaca();
        Perro perro = new Perro();
        Gato gato = new Gato();

        System.out.println(vaca.comerHierva());
        vaca.emitirSonido();

        System.out.println(perro.comerCarne());
        perro.emitirSonido();

        System.out.println(gato.comerCarne());
        gato.emitirSonido();

        System.out.println("Comiendo utilizando un método que verifica si el animal es herbívoro ");
        System.out.println(comerAnimal(vaca));
        System.out.println(comerAnimal(perro));
        System.out.println(comerAnimal(gato));

    }
}