package Exceptions;

public class ClientNotFoundException extends Exception{
    public ClientNotFoundException(String dni) {
        super("No existe un usuario con el DNI = " + dni);
    }
}
