package org.ejercicio_3;

public class Perro extends Animal implements IComerCarne {
    public Perro(boolean hervivoro, boolean carnivoro) {
        super(hervivoro, carnivoro);
    }

    public void emitirSonido() {
        System.out.println("guau");
    }

    public void comerCarne() {
        System.out.println("Perro come carne");
    }

}
