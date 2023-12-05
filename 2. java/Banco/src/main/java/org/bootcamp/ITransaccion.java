package org.bootcamp;

public interface ITransaccion {

    default void deposito(String cuenta){
        System.out.println("Realizando deposito en " + cuenta);
    }

    default void transferencia(String cuentaOrigen, String cuentaDestino){
        System.out.println("Realizando transferencia de " + cuentaOrigen + " a " + cuentaDestino);
    };

    default void consultaSaldo(String cuenta){
        System.out.println("Consultando saldo en " + cuenta);
    }

    default void pagoServicio(String servicio){
        System.out.println("Realizando pago de servicio " + servicio);
    }

    default void retiroEfectivo(String cuenta, Double monto){
        System.out.println("Realizando retiro de efectivo de " + cuenta + " por el monto " + monto);
    }

    default void transaccionOk(){
        System.out.println("Transacción Ok");
    }

    default void transaccionNoOk(){
        System.out.println("Transaccion Fallida");
    }

}
