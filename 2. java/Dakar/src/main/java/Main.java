import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList<>();
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        Carrera carrera = new Carrera(100,100000,"Dakar",3,vehiculoList,socorristaAuto,socorristaMoto);

        carrera.darDeAltaAuto(100,100,100,"A1");
        carrera.darDeAltaAuto(80,80,80,"A2");
        carrera.darDeAltaMoto(50,50,50,"M1");
        carrera.darDeAltaMoto(60,60,60,"M2");

        carrera.eliminarVehiculo(carrera.getVehiculoList().get(1));

        carrera.eliminarVehiculoConPatente("A2");

        carrera.determinarGanador();

        carrera.socorrerAuto("A1");
        carrera.socorrerMoto("M1");
    }
}
