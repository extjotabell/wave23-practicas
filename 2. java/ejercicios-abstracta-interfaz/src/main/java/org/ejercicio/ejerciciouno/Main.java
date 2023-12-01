package org.ejercicio.ejerciciouno;

import org.ejercicio.ejerciciouno.model.impl.Basic;
import org.ejercicio.ejerciciouno.model.impl.Cobrador;
import org.ejercicio.ejerciciouno.model.impl.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Cobrador cobrador = new Cobrador();
        Basic basic = new Basic();
        Ejecutivo ejecutivo = new Ejecutivo();

        cobrador.consultaDeSaldo();
        cobrador.retirarEfectivo(2000);
        System.out.println();
        basic.consultaDeSaldo();
        basic.pagarServicio("Cuota de manejo");
        basic.retirarEfectivo(23088);
        System.out.println();
        ejecutivo.deposito(399900);
        ejecutivo.transferir("29087-983-89", 45637.9);

    }
}
