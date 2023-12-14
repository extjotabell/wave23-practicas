package meli.bootcamp.spring.learning.ej11.util;

import java.security.SecureRandom;

public class PasswordGenerator {

  private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

  public String generatePassword() {
    SecureRandom random = new SecureRandom();
    StringBuilder contrasena = new StringBuilder();
    int longitud = 6;

    for (int i = 0; i < longitud; i++) {
      int indice = random.nextInt(CARACTERES_PERMITIDOS.length());
      char caracter = CARACTERES_PERMITIDOS.charAt(indice);
      contrasena.append(caracter);
    }

    return contrasena.toString();
  }

}
