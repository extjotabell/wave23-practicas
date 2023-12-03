package Ejercicio1;

import Ejercicio1.Clientes.Basic;
import Ejercicio1.Clientes.Cobradores;
import Ejercicio1.Clientes.Ejecutivo;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        Cobradores cobrador = new Cobradores();
        cobrador.consultaDeSaldo();
        cobrador.retiroDeEfectivo();

        Basic basic = new Basic();
        basic.consultaDeSaldo();
        basic.pagoDeServicios();
        basic.retiroDeEfectivo();

    }
}