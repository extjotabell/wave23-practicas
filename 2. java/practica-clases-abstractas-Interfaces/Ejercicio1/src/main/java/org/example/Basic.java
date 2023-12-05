package org.example;

public class Basic extends Cliente{
    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.noTransaccionOk();
    }

    @Override
    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.noTransaccionOk();
    }

}
