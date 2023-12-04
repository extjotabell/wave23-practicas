package org.example;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic         = new Basic();
        Cobrador cobrador   = new Cobrador();

        System.out.println(ejecutivo.toString());
        ejecutivo.deposito();
        ejecutivo.transferencia();
        ejecutivo.consultaSaldo();
        ejecutivo.retiroEfectivo();
        ejecutivo.pagoServicios();

        System.out.println(basic.toString());
        basic.deposito();
        basic.transferencia();
        basic.consultaSaldo();
        basic.retiroEfectivo();
        basic.pagoServicios();

        System.out.println(cobrador.toString());
        cobrador.deposito();
        cobrador.transferencia();
        cobrador.consultaSaldo();
        cobrador.retiroEfectivo();
        cobrador.pagoServicios();
    }
}