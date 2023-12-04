package model;

import interfaces.CRUD;

public class ReservasRepository extends CRUD<Reserva> {
    public int cantidadReservas(){
        return getModels().size();
    }
}
