package Exceptions;

public class ProductoNotFoundException extends ElementNotFoundException{
    public ProductoNotFoundException(String codigo) {
        super("No existe un producto con el codigo = " + codigo);
    }
}
