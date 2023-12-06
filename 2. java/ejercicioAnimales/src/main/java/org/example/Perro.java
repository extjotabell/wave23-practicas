package org.example;

public class Perro extends Animal implements ICarnivoro{
    public String nombre;

    public Perro(String nombre) {
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
        return super.emitirSonido() + "GUAU" + ". Su nombre es: " + this.nombre;
    }

    @Override
    public void comer(){
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro " + this.nombre + " come carne");
    }
}
