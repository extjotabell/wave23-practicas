package meli.bootcamp.spring.learning.exceptions.ej4;

public class MensajeInvalidoException extends RuntimeException {
  public MensajeInvalidoException(String message) {
    super(message);
  }
}
