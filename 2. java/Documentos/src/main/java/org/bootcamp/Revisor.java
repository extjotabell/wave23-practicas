package org.bootcamp;

public class Revisor extends Persona{

    protected int identificador;

    public Revisor(String nombre, String apellido, int edad, int identificador) {
        super(nombre, apellido, edad);
        this.identificador = identificador;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return "Revisor{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }

}
