package meli.bootcamp.ej6.transaccion;

public class DepositoImpl implements ITransaccionable{

  @Override
  public void transaccionOk() {
    System.out.println("Se realizo deposito");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("No se pudo realizar el deposito");
  }
  
}
