import java.util.ArrayList;

public class Garaje {

    private String id;
    private ArrayList<Vehiculo> vehiculos;

    public Garaje(String id) {
        this.id = id;
        this.vehiculos = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void agregarVehiculo(Vehiculo nuevoVehiculo){
        this.vehiculos.add(nuevoVehiculo);
    }
}
