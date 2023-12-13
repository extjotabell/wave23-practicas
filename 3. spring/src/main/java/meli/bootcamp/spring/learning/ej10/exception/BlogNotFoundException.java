package meli.bootcamp.spring.learning.ej10.exception;

public class BlogNotFoundException extends RuntimeException {
  public BlogNotFoundException(String message) {
    super(message);
  }
}
