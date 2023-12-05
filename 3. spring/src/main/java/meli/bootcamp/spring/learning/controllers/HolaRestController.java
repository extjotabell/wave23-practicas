package meli.bootcamp.spring.learning.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaRestController {
  @GetMapping
  public String sayHello() {
    return "Hola";
  }

  @GetMapping("/{name}")
  public String sayHello(@PathVariable String name) {
    return "Hola " + name;
  }
}
