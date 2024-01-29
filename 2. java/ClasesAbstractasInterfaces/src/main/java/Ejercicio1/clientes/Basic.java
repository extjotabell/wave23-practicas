package Ejercicio1.clientes;


import Ejercicio1.transacciones.*;

public class Basic extends Cliente{

    public void realizarConsultaSaldo(){
        super.realizarTransaccion(new ConsultaSaldo());
    }

    public void realizarRetiroDeEfectivo(){
        super.realizarTransaccion(new RetiroDeEfectivo());
    }

    public void realizarPagoDeServicios(){super.realizarTransaccion(new PagoDeServicios());}
}