package org.example;

public class Reserva {
    private int id;
    private String tipo;
    private int monto;

    public Reserva(int id, String tipo, int monto) {
        this.id = id;
        this.tipo = tipo;
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                ", monto=" + monto +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
