package org.example;

import java.util.HashMap;
import java.util.Map;

public class Inscripcion {

    int numero_inscripcion;
    Categoria categoria;
    Participante participante;
    double monto;

    static int contador_numero;

    Map<Integer, Inscripcion> inscriptos = new HashMap<>();

    public Inscripcion(Categoria categoria, Participante participante){
        this.numero_inscripcion = ++Inscripcion.contador_numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = Categoria.precioCategoria(participante.edad, categoria.nombre);
    }

}
