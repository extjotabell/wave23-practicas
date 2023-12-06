package org.example;

public class Gato extends Animal implements ICarnivoro{
    public String nombre;

    public Gato(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String emitirSonido(){
        return super.emitirSonido() + "MIAU" + ". Su nombre es: " + this.nombre;
    }

    @Override
    public void comer(){
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato " + this.nombre + " come carne");
    }
}
