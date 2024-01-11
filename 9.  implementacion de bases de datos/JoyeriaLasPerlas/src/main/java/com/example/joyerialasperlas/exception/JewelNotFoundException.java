package com.example.joyerialasperlas.exception;

public class JewelNotFoundException extends RuntimeException{

  public JewelNotFoundException(Long id) {
    super("Not exists a jewel with id = " + id);
  }
}
