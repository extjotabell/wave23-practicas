package com.mercadolibre.be_java_hisp_w23_g2.exception;

public class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

  public BadRequestException() {
  }
}
