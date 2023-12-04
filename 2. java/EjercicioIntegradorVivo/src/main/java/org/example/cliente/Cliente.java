package org.example.cliente;

import org.example.localizador.Localizador;

import java.util.*;

public class Cliente {

    private String nombre;

    private String apellido;

    private List<Localizador> localizadores;

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.localizadores = new ArrayList<>();
    }


    public Boolean tieneDosLocalizadores(){
        int count = 0;
        Localizador primerLocalizador = null;
        for (Localizador l: localizadores) {

            if(l.getDisponible()){
                if(count == 0) primerLocalizador = l;
                count++;

                if(count == 2){
                    primerLocalizador.setDisponible(false);
                    l.setDisponible(false);
                    return true;
                }
            }

        }
        return false;
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
