package org.mercadolibre.model;

public class NoPerecedero extends Producto{

    private String tipo;

    public NoPerecedero(String tipo, String nombre, double precio) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Alimento no perecedero de tipo=" + tipo + "\n";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
