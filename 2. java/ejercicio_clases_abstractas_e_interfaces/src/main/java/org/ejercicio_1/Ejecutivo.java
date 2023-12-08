package org.ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Ejecutivo {

    private Deposito deposito;
    private Transferencia transferencia;

    public Ejecutivo() {
        deposito = new Deposito();
        transferencia = new Transferencia();
    }

    public Deposito getDeposito() {
        return deposito;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }
}
