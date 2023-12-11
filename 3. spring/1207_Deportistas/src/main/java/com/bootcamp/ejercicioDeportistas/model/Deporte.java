package com.bootcamp.ejercicioDeportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Deporte {

    private static final List<Deporte> listaDeportes = new ArrayList<>();

    private String nombre;
    private int nivel;

    public static List<Deporte> getListaDeportes(){
        return listaDeportes;
    }

    public static void agregarDeporte(Deporte nuevoDeporte){
        listaDeportes.add(nuevoDeporte);
    }
}
