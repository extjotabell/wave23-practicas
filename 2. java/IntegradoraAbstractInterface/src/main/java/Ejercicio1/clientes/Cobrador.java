package Ejercicio1.clientes;

import Ejercicio1.transacciones.ConsultaSaldo;
import Ejercicio1.transacciones.PagoDeServicios;
import Ejercicio1.transacciones.RetiroDeEfectivo;

public class Cobrador extends Cliente{

    public void realizarConsultaSaldo(){
        super.realizarTransaccion(new ConsultaSaldo());
    }

    public void realizarRetiroDeEfectivo(){
        super.realizarTransaccion(new RetiroDeEfectivo());
    }

}
