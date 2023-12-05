package meli.bootcamp.spring.learning.controllers.ej1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("ej1")
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
