package main;

public class Item {
    private int codigo;
    private String nombre;
    private int cantComprada;
    private double costoUnitario;

    public Item(int codigo, String nombre, int cantComprada, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantComprada = cantComprada;
        this.costoUnitario = costoUnitario;
    }
}
