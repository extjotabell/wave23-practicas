package org.example_2;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Roberto","Carnivoro");
        Gato gato = new Gato("Roberta","Carnivoro");
        Vaca vaca = new Vaca("Lola","Herbivoro");

        perro.hacerSonido();
        ((Comiendo) perro).comerAnimal(perro);
        gato.hacerSonido();
        ((Comiendo) gato).comerAnimal(gato);
        vaca.hacerSonido();
        ((Comiendo) vaca).comerAnimal(vaca);
    }
}
