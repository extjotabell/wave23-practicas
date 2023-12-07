package meli.bootcamp.spring.learning.services.ej5;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

@Service
public class EdadService {
  public int calcular(Integer dia, Integer mes, Integer anio) {

    LocalDate nacimiento = LocalDate.of(anio, mes, dia);

    return Period.between(nacimiento, LocalDate.now()).getYears();
  }
}
