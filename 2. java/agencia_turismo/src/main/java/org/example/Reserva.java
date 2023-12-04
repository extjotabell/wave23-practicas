package org.example;

public class Reserva {
    private boolean tieneHotel;
    private boolean tieneComida;
    private boolean tieneboletos;

    private boolean tieneTransporte;


    public boolean isTieneHotel() {
        return tieneHotel;
    }

    public void setTieneHotel(boolean tieneHotel) {
        this.tieneHotel = tieneHotel;
    }

    public boolean isTieneComida() {
        return tieneComida;
    }

    public void setTieneComida(boolean tieneComida) {
        this.tieneComida = tieneComida;
    }

    public boolean isTieneboletos() {
        return tieneboletos;
    }

    public void setTieneboletos(boolean tieneboletos) {
        this.tieneboletos = tieneboletos;
    }

    public boolean isTieneTransporte() {
        return tieneTransporte;
    }

    public void setTieneTransporte(boolean tieneTransporte) {
        this.tieneTransporte = tieneTransporte;
    }

    public Reserva(boolean tieneHotel, boolean tieneComida, boolean tieneboletos, boolean tieneTransporte) {
        this.tieneHotel = tieneHotel;
        this.tieneComida = tieneComida;
        this.tieneboletos = tieneboletos;
        this.tieneTransporte = tieneTransporte;
    }

    public boolean esPaqueteCompleto() {
        return this.tieneboletos && this.tieneHotel && this.tieneComida && this.tieneTransporte;
    }

    @Override
    public String toString() {
        return "Reserva {  " +
                "tieneHotel = " + tieneHotel +
                ", tieneComida = " + tieneComida +
                ", tieneboletos = " + tieneboletos +
                ", tieneTransporte = " + tieneTransporte +
                " } ";
    }
}
