package com.example.joyerialasperlas.exception;

public class IllegalJewelCreationException extends RuntimeException{

  public IllegalJewelCreationException() {
    super("The jewel must be for sale for its creation");
  }
}
