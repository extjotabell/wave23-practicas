package org.example;

import org.example.banco.ConsultaDeSaldo;
import org.example.banco.RetiroDeEfectivo;

public class Cobrador implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public void realizarConsultaDeSaldo() {
        System.out.println("Realizando consulta de saldo");
        transaccionOk();
    }

    @Override
    public void realizarRetiroDeEfectivo() {
        System.out.println("Realizando retiro de efectivo");
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no Ok");
    }
}
