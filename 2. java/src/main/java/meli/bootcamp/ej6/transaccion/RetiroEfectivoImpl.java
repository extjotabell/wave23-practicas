package meli.bootcamp.ej6.transaccion;

public class RetiroEfectivoImpl implements ITransaccionable{

  @Override
  public void transaccionOk() {
    System.out.println("Se pudo retirar efectivo");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("No se pudo retirar efectivo");
  }
  
}
