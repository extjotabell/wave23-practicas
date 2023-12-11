package meli.bootcamp.spring.learning.ej2.controller;

import java.util.TreeMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ej2")
public class RomanRestController {
  private static TreeMap<Integer, String> romanMap = new TreeMap<>();

  static {
    romanMap.put(1000, "M");
    romanMap.put(900, "CM");
    romanMap.put(500, "D");
    romanMap.put(400, "CD");
    romanMap.put(100, "C");
    romanMap.put(90, "XC");
    romanMap.put(50, "L");
    romanMap.put(40, "XL");
    romanMap.put(10, "X");
    romanMap.put(9, "IX");
    romanMap.put(5, "V");
    romanMap.put(4, "IV");
    romanMap.put(1, "I");
  }

  @GetMapping("/{decimal}")
  public String decimalToRoman(@PathVariable Integer decimal) {
    int l = romanMap.floorKey(decimal);
    if (decimal == l) {
      return romanMap.get(decimal);
    }
    return romanMap.get(l) + decimalToRoman(decimal - l);
  }
}
