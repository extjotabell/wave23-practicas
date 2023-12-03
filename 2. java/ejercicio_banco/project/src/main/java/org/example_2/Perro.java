package org.example_2;

public class Perro extends Animal implements Comiendo{
    @Override
    public void hacerSonido(){
        System.out.println("El perro ladra guau");
    }

    @Override
    public String obtenerTipo() {
        return "Carnivoro";
    }

    public Perro(String nombre, String tipo) {
        super(nombre, tipo);
    }

}
