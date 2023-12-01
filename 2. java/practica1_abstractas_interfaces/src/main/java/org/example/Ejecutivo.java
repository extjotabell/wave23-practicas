package org.example;

import org.example.banco.Deposito;
import org.example.banco.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void realizarDeposito() {
        System.out.println("Realizando deposito");
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no Ok");
    }

    @Override
    public void realizarTransferencia() {
        System.out.println("Realizando transferencia");
        transaccionOk();
    }
}
