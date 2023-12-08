package org.ejercicio_1;

public class Main {

    public static void RandomFailTransaction(ITransaccion transaccion){
        if (Math.random() < 0.2) transaccion.transaccionNoOk();
        else transaccion.transaccionOk();
    }
    public static void main(String[] args) {
        Ejecutivo martin = new Ejecutivo();
        Cobradores claudia = new Cobradores();
        Basic lucas = new Basic();

        RandomFailTransaction(martin.getDeposito());
        RandomFailTransaction(martin.getTransferencia());

        RandomFailTransaction(claudia.getConsultaSaldo());
        RandomFailTransaction(claudia.getRetiroDeEfectivo());

        RandomFailTransaction(lucas.getRetiroDeEfectivo());
        RandomFailTransaction(lucas.getConsultaSaldo());
        RandomFailTransaction(lucas.getPagoServicio());

    }
}