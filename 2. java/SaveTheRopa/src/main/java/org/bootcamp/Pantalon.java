package org.bootcamp;

public class Pantalon extends Prenda{

    public Pantalon(int id, String marca, String modelo) {
        super(id, marca, modelo);
    }

    @Override
    public String toString() {
        return "Pantalon{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

}
