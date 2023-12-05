package org.test;

import org.bootcamp.Basic;
import org.bootcamp.Cobrador;
import org.bootcamp.Ejecutivo;

public class Main {

    public static void main(String[] args){
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();
        Cobrador cobrador = new Cobrador();

        basic.consultaSaldo("1234567-89");
        basic.pagoServicio("Agua Potable");
        basic.retiroEfectivo("1234567-89", 15000D);

        ejecutivo.deposito("9876543-21");
        ejecutivo.transferencia("9876543-21", "1234567-89");

        cobrador.consultaSaldo("7658762-12");
        cobrador.retiroEfectivo("7658762-12", 30000D);

    }

}
