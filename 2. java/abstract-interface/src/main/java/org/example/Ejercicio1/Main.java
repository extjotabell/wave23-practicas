package org.example;

public class Main {
    public static void main(String[] args) {
        Ejecutivos ejecutivos = new Ejecutivos();
        ejecutivos.realizarDeposito();
        ejecutivos.realizarTransferencia();

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagarServicios();
        basic.realizarRetiroEfectivo();

        Cobradores cobrador = new Cobradores();
        cobrador.realizarRetiroEfectivo();
        cobrador.consultarSaldo();
    }
}