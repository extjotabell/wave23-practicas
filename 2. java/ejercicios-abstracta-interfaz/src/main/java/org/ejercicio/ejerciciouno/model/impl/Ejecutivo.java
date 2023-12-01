package org.ejercicio.ejerciciouno.model.impl;

import org.ejercicio.ejerciciouno.model.interfaces.IDeposito;
import org.ejercicio.ejerciciouno.model.interfaces.ITransferencia;

public class Ejecutivo implements IDeposito, ITransferencia {

    @Override
    public void transaccionOk() {
        System.out.println("   EJEC -- TRANSACCION EXITOSA.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("   EJEC -- TRANSACCION NO EXITOSA.");
    }

    @Override
    public void deposito(double cantidad) {
        System.out.println("EJEC -- depositando..... $" + cantidad);
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }

    @Override
    public void transferir(String numeroCuenta, double cantidad) {
        System.out.println("EJEC -- depositando a "+ numeroCuenta + "  $" + cantidad);
        if ((int)(Math.random()*10+1) %2 == 0) transaccionOk();
        else transaccionNoOk();
    }
}
