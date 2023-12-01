import java.util.ArrayList;
import java.util.List;

public class Garage {

    private int id;
    List <Vehiculo> listaVehiculo = new ArrayList();


    public Garage(int id, List<Vehiculo> listaVehiculo) {
        this.id = id;
        this.listaVehiculo = listaVehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }
}
