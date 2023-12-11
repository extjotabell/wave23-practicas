package meli.bootcamp.spring.learning.ej4.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import meli.bootcamp.spring.learning.ej4.exception.MensajeInvalidoException;

@Service
public class CodigoMorseService {
  private static final HashMap<String, String> library = new HashMap<String, String>();
  static {
    library.put(".-", "A");
    library.put("-...", "B");
    library.put("-.-.", "C");
    library.put("-..", "D");
    library.put(".", "E");
    library.put("..-.", "F");
    library.put("--.", "G");
    library.put("....", "H");
    library.put("..", "I");
    library.put(".---", "J");
    library.put("-.-", "K");
    library.put(".-..", "L");
    library.put("--", "M");
    library.put("-.", "N");
    library.put("---", "O");
    library.put(".--.", "P");
    library.put("--.-", "Q");
    library.put(".-.", "R");
    library.put("...", "S");
    library.put("-", "T");
    library.put("..-", "U");
    library.put("...-", "V");
    library.put(".--", "W");
    library.put("-..-", "X");
    library.put("-.--", "Y");
    library.put("--..", "Z");
    library.put(".----", "1");
    library.put("..---", "2");
    library.put("...--", "3");
    library.put("....-", "4");
    library.put(".....", "5");
    library.put("-....", "6");
    library.put("--...", "7");
    library.put("---..", "8");
    library.put("----.", "9");
    library.put("-----", "0");
  }

  public String decodificar(String mensaje) {
    StringBuilder decodificado = new StringBuilder();
    String[] splitPalabras = mensaje.split("   ");

    for (String palabra : splitPalabras) {
      String[] splitLetras = palabra.split(" ");
      for (String letra : splitLetras) {
        String letraDecodificada = library.get(letra);
        decodificado.append(letraDecodificada);
      }
      decodificado.append(" ");
    }

    return decodificado.toString().trim();
  }

  public String codificar(String mensaje) {
    mensaje = mensaje.toUpperCase();

    if (!esMensajeValido(mensaje)) {
      throw new MensajeInvalidoException("El mensaje posee caracteres no válidos.");
    }

    StringBuilder codificado = new StringBuilder();
    String[] splitPalabras = mensaje.split(" ");

    for (String palabra : splitPalabras) {
      for (Character letra : palabra.toCharArray()) {
        String letraCodificada = this.getLetraAsociada(letra);
        codificado.append(letraCodificada);
        codificado.append(" ");
      }
      codificado.append("  ");
    }

    return codificado.toString().trim();
  }

  private boolean esMensajeValido(String mensaje) {

    if (mensaje.isBlank()) {
      return false;
    }

    return mensaje.matches("[a-zA-Z0-9\\s]+");
  }

  private String getLetraAsociada(Character letra) {
    String letraCodificada = "";

    for (Map.Entry<String, String> entry : library.entrySet()) {
      if (entry.getValue().equals(letra.toString())) {
        letraCodificada = entry.getKey();
        break;
      }
    }

    return letraCodificada;
  }
}
