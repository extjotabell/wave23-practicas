package org.example.model;

public class RinesDeLujo implements IVehiculo {
    protected IVehiculo vehiculo;

    public RinesDeLujo(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Double getPrecio(){
        return vehiculo.getPrecio() +10.0;
    }
    public String getAccesorios(){
        return vehiculo.getAccesorios() + " Rines de lujo  ";
    }
}
