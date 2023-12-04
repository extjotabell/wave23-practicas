package Exceptions;

public class FacturaNotFoundException extends ElementNotFoundException {
    public FacturaNotFoundException(String id) {
        super("No existe una factura con el ID = " + id);
    }
}
