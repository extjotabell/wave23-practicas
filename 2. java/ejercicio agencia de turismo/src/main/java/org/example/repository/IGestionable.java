package org.example.repository;

import org.example.entities.Cliente;
import org.example.entities.Localizador;
import org.example.entities.Reserva;

import java.util.ArrayList;
import java.util.Optional;

public interface IGestionable <T> {
    public String guardar(T objeto);
    public ArrayList<T> buscar(T objeto);
    public int cantidadRegistros();
}
