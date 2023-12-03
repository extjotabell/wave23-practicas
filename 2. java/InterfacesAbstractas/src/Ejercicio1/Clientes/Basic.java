package Ejercicio1.Clientes;

import Ejercicio1.Transacciones.ConsultaDeSaldo;
import Ejercicio1.Transacciones.PagoDeServicios;

public class Basic {
    public void consultaDeSaldo(){
        ConsultaDeSaldo consulta = new ConsultaDeSaldo();
        consulta.transaccionOk();
    }

    public void pagoDeServicios(){
        PagoDeServicios pago = new PagoDeServicios();
        pago.transaccionOk();
    }

    public void retiroDeEfectivo(){
        RetiroDeEfectivo retiro = new RetiroDeEfectivo();
        retiro.transaccionOk();
    }
}
