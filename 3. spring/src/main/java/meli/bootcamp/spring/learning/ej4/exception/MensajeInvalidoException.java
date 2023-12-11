package meli.bootcamp.spring.learning.ej4.exception;

public class MensajeInvalidoException extends RuntimeException {
  public MensajeInvalidoException(String message) {
    super(message);
  }
}
