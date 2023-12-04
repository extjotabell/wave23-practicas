package org.example;

public abstract class Transaccion {
    protected String mensajeReturn;
    protected String transaccionOk() {
        mensajeReturn = "Transaccion exitosa: OK";
        return mensajeReturn;
    }

    protected String transaccionNoOk() {
        mensajeReturn = "Transaccion no exitosa: NOK";
        return mensajeReturn;
    }
}
