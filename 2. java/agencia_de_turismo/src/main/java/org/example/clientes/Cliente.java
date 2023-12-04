package org.example.clientes;

import org.example.localizadores.Localizador;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String dni;
    private String nombre;
    private final List<Localizador> localizadores;

    public Cliente(String dni) {
        this.dni = dni;
        this.localizadores = new ArrayList<>();
    }

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
