package meli.bootcamp.spring.learning.ej10.exception;

public class NoBlogsFoundException extends RuntimeException {
  public NoBlogsFoundException(String message) {
    super(message);
  }
}
