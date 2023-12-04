package Exceptions;

public class ClientNotFoundException extends ElementNotFoundException {
    public ClientNotFoundException(String dni) {
        super("No existe un usuario con el DNI = " + dni);
    }
}
