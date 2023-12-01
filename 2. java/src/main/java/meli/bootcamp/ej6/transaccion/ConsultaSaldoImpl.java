package meli.bootcamp.ej6.transaccion;

public class ConsultaSaldoImpl implements ITransaccionable{

  @Override
  public void transaccionOk() {
    System.out.println("Se consulto el saldo");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("No se pudo consultar el saldo");
  }
  
}
