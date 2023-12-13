package meli.bootcamp.spring.learning.ej10.entity;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class EntradaBlog {
  private Integer id;
  private String titulo;
  private String nombreAutor;
  private LocalDate fecha;

  public EntradaBlog(Integer id, String titulo, String nombreAutor) {
    this.id = id;
    this.titulo = titulo;
    this.nombreAutor = nombreAutor;
    this.fecha = LocalDate.now();
  }

}
