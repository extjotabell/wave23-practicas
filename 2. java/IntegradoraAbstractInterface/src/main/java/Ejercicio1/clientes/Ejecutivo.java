package Ejercicio1.clientes;

import Ejercicio1.transacciones.Deposito;
import Ejercicio1.transacciones.Transferencia;

public class Ejecutivo extends Cliente{

    public void realizarDeposito(){
        super.realizarTransaccion(new Deposito());
    }

    public void realizarTransferencia(){
        super.realizarTransaccion(new Transferencia());
    }
}
