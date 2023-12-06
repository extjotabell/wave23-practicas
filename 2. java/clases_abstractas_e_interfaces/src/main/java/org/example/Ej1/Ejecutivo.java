package org.example.Ej1;

public class Ejecutivo {

    public void realizarDeposito(){
        Transaccion transaccion = new Deposito();
        transaccion.transaccionOk();
    }

    public void relizarTransferencia(){
        Transaccion transaccion = new Transferencia();
        transaccion.transaccionOk();
    }
}
