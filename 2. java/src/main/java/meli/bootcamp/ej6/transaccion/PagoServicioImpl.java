package meli.bootcamp.ej6.transaccion;

public class PagoServicioImpl implements ITransaccionable{

  @Override
  public void transaccionOk() {
    System.out.println("Se pago el servicio");
  }

  @Override
  public void transaccionNoOk() {
    System.out.println("No se pudo pagar el servicio");
  }
  
}
