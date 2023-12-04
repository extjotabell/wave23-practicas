public class SocorristaMoto extends VehiculoSocorrista {
    @Override
    void socorrer(Vehiculo vehiculo) {
        System.out.println("Socorriendo moto, patente: " + vehiculo.getPatente());
    }
}
