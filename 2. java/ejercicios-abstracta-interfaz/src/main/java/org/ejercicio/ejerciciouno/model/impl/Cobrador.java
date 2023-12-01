package org.ejercicio.ejerciciouno.model.impl;

import org.ejercicio.ejerciciouno.model.interfaces.IConsultaDeSaldo;
import org.ejercicio.ejerciciouno.model.interfaces.IRetiroEfectivo;

public class Cobrador implements IRetiroEfectivo, IConsultaDeSaldo {
    @Override
    public void transaccionOk() {
        System.out.println("   COBRADOR -- TRANSACCION EXITOSA.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("   COBRADOR -- TRANSACCION NO EXITOSA.");
    }

    @Override
    public void consultaDeSaldo() {
        System.out.println("COBRADOR -- SU SALDO ES .... $0");
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }

    @Override
    public void retirarEfectivo(double cantidad) {
        System.out.println("COBRADOR -- retirando..... $" + cantidad);
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }
}
