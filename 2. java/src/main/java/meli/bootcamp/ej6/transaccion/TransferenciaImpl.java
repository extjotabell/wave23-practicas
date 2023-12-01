package meli.bootcamp.ej6.transaccion;

public class TransferenciaImpl implements ITransaccionable{

  @Override
  public void transaccionOk() {
    System.out.println("Se realizo la transferencia");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("No se pudo realizar la transferencia");
  }
  
}
