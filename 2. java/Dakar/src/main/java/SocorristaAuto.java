public class SocorristaAuto extends VehiculoSocorrista{
    @Override
    void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo auto, patente: " + vehiculo.getPatente());
    }
}
