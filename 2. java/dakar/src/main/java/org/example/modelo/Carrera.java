package org.example.modelo;
import java.util.LinkedList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double precioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos = new LinkedList<>();

    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(Double distancia, Double precioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.precioEnDolares = precioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        try {
            if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
                listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            } else {
                throw new RuntimeException("No se pueden agregar mas vehiculos autos - sin cupos");
            }
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        try {
            if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos){
                listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            } else {
                throw new RuntimeException("No se pueden agregar mas vehiculos motos - sin cupos");
            }
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculos){
        listaDeVehiculos.remove(vehiculos);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        boolean patenteEncontrada = false;
        for (Vehiculo vehiculo: listaDeVehiculos) {
            if (vehiculo.getPatente().equals(unaPatente)) {
                listaDeVehiculos.remove(vehiculo);
                System.out.println("Vehiculo con patente: " + unaPatente + " fue eliminado de la carrera");
                patenteEncontrada = true;
            }
        }
        if (!patenteEncontrada) {
            System.out.println("La patente no está registrada en la carrera, no se puede eliminar");
        }
    }

    public Vehiculo definirGanador(){
        Vehiculo ganador = null;
        Double maximo = 0.0;
        for(Vehiculo vehiculo : listaDeVehiculos){
            Double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if(valor > maximo){
                maximo = valor;
                ganador = vehiculo;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente){
        if (patente != null){
            boolean patenteEncontrada = false;
            for (Vehiculo vehiculo: listaDeVehiculos){
                if (vehiculo.getPatente().equals(patente)){
                    if (vehiculo instanceof Auto){
                        socorristaAuto.socorrer((Auto)vehiculo);
                        //elimina de carrera
                        eliminarVehiculo(vehiculo);
                        System.out.println("El auto con patente: " + patente + " fue socorrido");
                    } else {
                        System.out.println("No se puede socorrer un auto con un vehículo diseñado para motos");
                    }
                    patenteEncontrada = true;
                    break;
                }
            }
            if (!patenteEncontrada) {
                System.out.println("La patente no está registrada en la carrera.");
            }
        } else {
            System.out.println("No se proporcionó una patente válida");
        }
    }

    public void socorrerMoto(String patente){
        if (patente != null){
            boolean patenteEncontrada = false;
            for (Vehiculo vehiculo: listaDeVehiculos){
                if (vehiculo.getPatente().equals(patente)){
                    if (vehiculo instanceof Moto){
                        socorristaMoto.socorrer((Moto) vehiculo);
                        //elimina de carrera
                        eliminarVehiculo(vehiculo);
                        System.out.println("La moto con patente: " + patente + " fue socorrido");
                    } else {
                        System.out.println("No se puede socorrer una moto con un vehículo diseñado para autos");
                    }
                    patenteEncontrada = true;
                    break;
                }
            }
            if (!patenteEncontrada) {
                System.out.println("La patente no está registrada en la carrera.");
            }
        } else {
            System.out.println("No se proporcionó una patente válida");
        }
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPrecioEnDolares() {
        return precioEnDolares;
    }

    public void setPrecioEnDolares(Double precioEnDolares) {
        this.precioEnDolares = precioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
