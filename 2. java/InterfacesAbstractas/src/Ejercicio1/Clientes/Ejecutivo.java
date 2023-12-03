package Ejercicio1.Clientes;

import Ejercicio1.Transacciones.Deposito;
import Ejercicio1.Transacciones.Transferencia;

public class Ejecutivo {
    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}
