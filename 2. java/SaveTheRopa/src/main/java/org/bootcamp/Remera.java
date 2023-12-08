package org.bootcamp;

public class Remera extends Prenda{

    public Remera(int id, String marca, String modelo) {
        super(id, marca, modelo);
    }

    @Override
    public String toString() {
        return "Remera{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

}
