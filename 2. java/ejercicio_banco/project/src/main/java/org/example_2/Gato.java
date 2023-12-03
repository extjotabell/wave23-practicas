package org.example_2;

public class Gato extends Animal implements Comiendo{
    @Override
    public void hacerSonido(){
        System.out.println("El perro ladra guau");
    }

    @Override
    public String obtenerTipo() {
        return "Perro";
    }

    public Gato(String nombre, String tipo) {
        super(nombre, tipo);
    }
}
