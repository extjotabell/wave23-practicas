package org.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Cobradores {
    private RetiroDeEfectivo retiroDeEfectivo;
    private ConsultaSaldo consultaSaldo;

    public Cobradores() {
        retiroDeEfectivo = new RetiroDeEfectivo();
        consultaSaldo = new ConsultaSaldo();
    }

    public RetiroDeEfectivo getRetiroDeEfectivo() {
        return retiroDeEfectivo;
    }

    public ConsultaSaldo getConsultaSaldo() {
        return consultaSaldo;
    }
}
