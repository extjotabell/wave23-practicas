package org.example_2;

public class Vaca extends Animal implements Comiendo{
    @Override
    public void hacerSonido(){
        System.out.println("El perro ladra guau");
    }

    @Override
    public String obtenerTipo() {
        return "Perro";
    }

    public Vaca(String nombre, String tipo) {
        super(nombre, tipo);
    }
}
