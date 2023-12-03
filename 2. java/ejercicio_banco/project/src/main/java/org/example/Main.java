package org.example;

public class Main {
    public static void main(String[] args) {
        Ejecutivos martin = new Ejecutivos();
        Cobradores claudia = new Cobradores();
        Basic lucas = new Basic();

        martin.deposito();
        claudia.consultaDeSaldo();
        lucas.pagoDeServicios();
    }
}