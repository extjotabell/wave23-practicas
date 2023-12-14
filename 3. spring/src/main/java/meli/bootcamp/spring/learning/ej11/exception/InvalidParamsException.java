package meli.bootcamp.spring.learning.ej11.exception;

public class InvalidParamsException extends RuntimeException {
  public InvalidParamsException(String message) {
    super(message);
  }
}
