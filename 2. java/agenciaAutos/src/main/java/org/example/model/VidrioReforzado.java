package org.example.model;

public class VidrioReforzado implements IVehiculo{
    protected IVehiculo vehiculo;

    public VidrioReforzado(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Double getPrecio(){
        return vehiculo.getPrecio() +20.0;
    }
    public String getAccesorios(){
        return vehiculo.getAccesorios() + " Vidrio reforzados ";
    }
}
