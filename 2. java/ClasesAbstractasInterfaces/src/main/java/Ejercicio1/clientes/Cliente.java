package Ejercicio1.clientes;


import Ejercicio1.transacciones.Transaccion;

import java.util.Random;

public abstract class Cliente {
    protected void realizarTransaccion(Transaccion transaccion) {
        double r = new Random().nextDouble();
        if (r > 0.5) {
            transaccion.transaccionNoOk();
        } else {
            transaccion.transaccionOk();
        }
    }
}