package org.ejercicio.modelo;

import java.util.List;
import java.util.Optional;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;



    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;

        this.socorristaAuto = new SocorristaAuto(100.0, 10.0, 5.0, "SOCORR. MOTO", 300.0, 4);
        this.socorristaMoto = new SocorristaMoto(100.0, 10.0, 5.0, "SOCORR. MOTO", 300.0, 4);

    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro,String patente){
        if (validarCupo()) {
            Vehiculo auto = new Auto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(auto);
        };
    }
    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro,String patente){
        if (validarCupo()) {
            Vehiculo moto = new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(moto);
        }
    }

    public void darDeAltaAuto(Auto auto){
        if (validarCupo()) {
            vehiculos.add(auto);
        };
    }
    public void darDeAltaMoto(Moto moto){
        if (validarCupo()) {
            vehiculos.add(moto);
        }
    }


    public void eliminarVehiculo(Vehiculo vehiculo) throws ExcepcionCarrera {
        if (vehiculos.contains(vehiculo)) vehiculos.remove(vehiculo);
        else throw new ExcepcionCarrera("El vehiculo no esta registrado en la carrera");
    }

    public void eliminarVehiculoConPatente(String patente) throws ExcepcionCarrera {
        Optional<Vehiculo> vehiculo = vehiculos.stream().filter(p -> p.getPatente().equals(patente)).findFirst();
        eliminarVehiculo(vehiculo.get());
    }

    public Vehiculo obtenerGanador(){
        // Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)
        Double velocidadAux = 0.0;
        Double velocidadActual = 0.0;
        Vehiculo vehiculoGanador = vehiculos.get(0);
        for (Vehiculo v : vehiculos){
            velocidadActual = v.getVelocidad()*(0.5*v.getAceleracion()) / ( v.getAnguloDeGiro()*(v.getPeso() - (v.getRuedas()*100)));
            if (velocidadAux < velocidadActual) {
                velocidadAux = velocidadActual;
                vehiculoGanador = v;
            }

        }
        return vehiculoGanador;
    }
    public void socorrerAuto(String patente){
        this.getSocorristaAuto().socorrer((Auto) vehiculos.stream().filter(p -> p.getPatente().equals(patente)).findFirst().get());
    }
    public void socorrerMoto(String patente){
        this.getSocorristaMoto().socorrer((Moto) vehiculos.stream().filter(p -> p.getPatente().equals(patente)).findFirst().get());
    }


    private boolean validarCupo(){
        return cantidadDeVehiculosPermitidos > vehiculos.size();
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
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

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

}
