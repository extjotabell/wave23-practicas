package org.example.ejercicio1;

public abstract class Cliente {

    public void realizarTransaccion(ITransaccion transaccion){
        System.out.println("Transaccion " + transaccion.getClass().getSimpleName() + " en Proceso");
    };
}
