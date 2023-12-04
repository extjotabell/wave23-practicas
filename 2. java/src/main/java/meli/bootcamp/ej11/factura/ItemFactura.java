package meli.bootcamp.ej11.factura;

public class ItemFactura {
  private String codigo;
  private String nombreProducto;
  private int cantidad;
  private Double costoUnitario;

  public ItemFactura(String codigo, String nombreProducto, int cantidad, Double costoUnitario) {
    this.codigo = codigo;
    this.nombreProducto = nombreProducto;
    this.cantidad = cantidad;
    this.costoUnitario = costoUnitario;
  }

  public String getCodigo() {
    return codigo;
  }

  public String getNombreProducto() {
    return nombreProducto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public Double getCostoUnitario() {
    return costoUnitario;
  }

  @Override
  public String toString() {
    return codigo + "-" + nombreProducto + "(" + cantidad + ")";
  }

}
