package org.ejercicio.ejerciciouno.model.impl;

import org.ejercicio.ejerciciouno.model.interfaces.IConsultaDeSaldo;
import org.ejercicio.ejerciciouno.model.interfaces.IPagoDeServicios;
import org.ejercicio.ejerciciouno.model.interfaces.IRetiroEfectivo;

public class Basic implements IConsultaDeSaldo, IPagoDeServicios, IRetiroEfectivo {
    @Override
    public void transaccionOk() {
        System.out.println("   BASIC -- TRANSACCION EXITOSA.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("   BASIC -- TRANSACCION NO EXITOSA.");
    }

    @Override
    public void consultaDeSaldo() {
        System.out.println("BASIC -- SU SALDO ES .... $0");
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }

    @Override
    public void pagarServicio(String servicio) {
        System.out.println("BASIC -- pagando el servicio..... $" + servicio);
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }

    @Override
    public void retirarEfectivo(double cantidad) {
        System.out.println("BASIC -- retirando..... $" + cantidad);
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }
}
