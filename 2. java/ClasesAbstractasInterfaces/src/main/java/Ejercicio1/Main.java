package Ejercicio1;


import Ejercicio1.clientes.Basic;
import Ejercicio1.clientes.Cobrador;
import Ejercicio1.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        Basic basic = new Basic();
        Cobrador cobrador=new Cobrador();

        System.out.println("Transacciones de ejecutivo");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        System.out.println("Transacciones de basic");
        basic.realizarConsultaSaldo();
        basic.realizarRetiroDeEfectivo();
        basic.realizarPagoDeServicios();

        System.out.println("Transacciones de cobrador");
        cobrador.realizarConsultaSaldo();
        cobrador.realizarRetiroDeEfectivo();
    }

}