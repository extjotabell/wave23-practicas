package org.example;

public class Vaca extends Animal implements IHerbivoro{
    public String nombre;

    public Vaca(String nombre) {
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
        return super.emitirSonido() + "MUUU" + ". Su nombre es: " + this.nombre;
    }

    @Override
    public void comer(){
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca " + this.nombre + " come hierbas");
    }
}
