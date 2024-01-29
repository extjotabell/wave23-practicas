package org.example;

public class Ejecutivos extends Cliente{
      public void realizarDeposito(){
          Deposito deposito = new Deposito();
          deposito.transaccionOk();
      }
      public void noRealizarDeposito(){
          Deposito deposito = new Deposito();
          deposito.transaccionNoOk();
      }
      public void realizarTransferencia(){
          Transferencia transferencia = new Transferencia();
          transferencia.transaccionNoOk();
      }
      public void noRealizarTransferencia(){
          Transferencia transferencia = new Transferencia();
          transferencia.transaccionNoOk();
      }
}
