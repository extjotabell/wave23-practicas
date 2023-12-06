package org.example.model;

public class ChapaProtectora implements IVehiculo{
    protected IVehiculo vehiculo;

    public ChapaProtectora(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Double getPrecio(){
        return vehiculo.getPrecio() +15.0;
    }
    public String getAccesorios(){
        return vehiculo.getAccesorios() + " Chapa protectora  ";
    }
}
