import models.Carrera;

public class Main{
    public static void main(String[] args) {
        Carrera carrera = new Carrera(20,3000,"Carrera en Buenos Aires", 4);
        carrera.darDeAltaAuto(30,50,120, "ABC 212");
        carrera.darDeAltaAuto(20,90,110, "ABC 232");
        carrera.darDeAltaAuto(60,10,140, "ABC 214");
        carrera.darDeAltaMoto(50,100,170, "ABD 214");
        carrera.darDeAltaMoto(80,60,140, "ABD 546");

        carrera.eliminarVehiculoConPatente("ABC 212");

        carrera.darDeAltaMoto(80,60,140, "ABD 546");

        System.out.println("El vehiculo ganador es: "+ carrera.ganador());

        carrera.socorrerAuto("ABC 212");
        carrera.socorrerMoto("ABC 232");

    }
}
