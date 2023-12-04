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

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        try {
            if (patente == null || velocidad == null || aceleracion == null || anguloDeGiro == null) {
                throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
            }

            if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
                listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            } else {
                throw new RuntimeException("No se pueden agregar más vehículos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        try {
            if (patente == null || velocidad == null || aceleracion == null || anguloDeGiro == null) {
                throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
            }

            if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
                listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            } else {
                throw new RuntimeException("No se pueden agregar más vehículos");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Vehiculo definirGanador() {
        try {
            if (listaDeVehiculos.isEmpty()) {
                throw new IllegalStateException("No hay vehículos en la lista");
            }

            Vehiculo ganador = null;
            Double maximo = 0.0;

            for (Vehiculo vehiculo : listaDeVehiculos) {
                Double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));

                if (valor > maximo) {
                    maximo = valor;
                    ganador = vehiculo;
                }
            }

            if (ganador == null) {
                throw new RuntimeException("No se pudo determinar un ganador");
            }

            return ganador;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void socorrerAuto(String patente) {
        try {
            if (patente == null) {
                throw new IllegalArgumentException("La patente no puede ser nula");
            }

            for (Vehiculo vehiculo : listaDeVehiculos) {
                if (vehiculo.getPatente().equals(patente)) {
                    if (vehiculo instanceof Auto) {
                        socorristaAuto.socorrer((Auto) vehiculo);
                        eliminarVehiculo(vehiculo);
                        System.out.println("El auto con patente " + patente + " fue socorrido.");
                    } else {
                        throw new RuntimeException("No se puede socorrer un auto con un vehículo diseñado para motos.");
                    }
                    return;
                }
            }

            throw new RuntimeException("La patente no está registrada en la carrera.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void socorrerMoto(String patente) {
        try {
            if (patente == null) {
                throw new IllegalArgumentException("La patente no puede ser nula");
            }

            for (Vehiculo vehiculo : listaDeVehiculos) {
                if (vehiculo.getPatente().equals(patente)) {
                    if (vehiculo instanceof Moto) {
                        socorristaMoto.socorrer((Moto) vehiculo);
                        eliminarVehiculo(vehiculo);
                        System.out.println("La moto con patente " + patente + " fue socorrida.");
                    } else {
                        throw new RuntimeException("No se puede socorrer una moto con un vehículo diseñado para autos.");
                    }
                    return;
                }
            }

            throw new RuntimeException("La patente no está registrada en la carrera.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
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
