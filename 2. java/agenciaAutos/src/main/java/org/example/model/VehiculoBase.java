package org.example.model;

public class VehiculoBase implements IVehiculo{
    private Double precio;
    private String modelo;
    private String accesorio;

    public VehiculoBase(Double precio, String modelo, String accesorio) {
        this.precio = precio;
        this.modelo = modelo;
        this.accesorio = accesorio;
    }

    @Override
    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String getAccesorios() {
        return this.accesorio;
    }

    public void setAccesorio(String accesorio) {
        this.accesorio = accesorio;
    }
}
