package org.example.model;

public class ManillasCromadas implements IVehiculo{
    protected IVehiculo vehiculo;

    public ManillasCromadas(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Double getPrecio(){
        return vehiculo.getPrecio() +12.5;
    }
    public String getAccesorios(){
        return vehiculo.getAccesorios() + " Manillas cromadas  ";
    }
}
