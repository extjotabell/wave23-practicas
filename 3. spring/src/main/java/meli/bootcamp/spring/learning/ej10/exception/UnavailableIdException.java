package meli.bootcamp.spring.learning.ej10.exception;

public class UnavailableIdException extends RuntimeException {
  public UnavailableIdException(String message) {
    super(message);
  }
}
