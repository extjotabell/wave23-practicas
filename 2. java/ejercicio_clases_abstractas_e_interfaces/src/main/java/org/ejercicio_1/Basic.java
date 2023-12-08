package org.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Basic {

    private ConsultaSaldo consultaSaldo;
    private PagoServicio pagoServicio;
    private RetiroDeEfectivo retiroDeEfectivo;

    public Basic() {
        consultaSaldo = new ConsultaSaldo();
        pagoServicio = new PagoServicio();
        retiroDeEfectivo = new RetiroDeEfectivo();
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }

    public PagoServicio getPagoServicio() {
        return pagoServicio;
    }

    public RetiroDeEfectivo getRetiroDeEfectivo() {
        return retiroDeEfectivo;
    }
}
