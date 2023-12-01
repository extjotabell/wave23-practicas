package org.example;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        basic.realizarPagoDeServicios();
        basic.realizarConsultaDeSaldo();
        basic.realizarRetiroDeEfectivo();

        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        cobrador.realizarConsultaDeSaldo();
        cobrador.realizarRetiroDeEfectivo();
    }
}
