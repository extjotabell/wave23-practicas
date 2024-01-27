package org.example.model;

import org.example.interfaces.CRUD;

public class ReservasRepository extends CRUD<Reserva> {
    public int cantidadReservas(){
        return getModels().size();
    }
}