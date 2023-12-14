package meli.bootcamp.spring.learning.ej11.util;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import meli.bootcamp.spring.learning.ej11.exception.InvalidURLException;

public class URLValidator {

  public boolean validateURL(String url) {
    try {
      // Intentar crear una instancia de URL
      new URI(url).toURL();
      return true;
    } catch (MalformedURLException e) {
      throw new InvalidURLException("Invalid URL");
    } catch (URISyntaxException e) {
      throw new InvalidURLException("Invalid URL");
    }
  }

}
