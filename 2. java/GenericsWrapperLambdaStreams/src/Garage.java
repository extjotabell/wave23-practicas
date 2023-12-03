import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;
    private int ID = 0;

    public Garage(List<Vehiculo> vehiculos) {
        this.id = this.ID++;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
