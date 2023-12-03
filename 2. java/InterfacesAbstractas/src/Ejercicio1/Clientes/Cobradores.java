package Ejercicio1.Clientes;

import Ejercicio1.Transacciones.ConsultaDeSaldo;

public class Cobradores {
    public void retiroDeEfectivo(){
        RetiroDeEfectivo retiro = new RetiroDeEfectivo();
        retiro.transaccionOk();
    }

    public void consultaDeSaldo(){
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.transaccionOk();
    }
}
