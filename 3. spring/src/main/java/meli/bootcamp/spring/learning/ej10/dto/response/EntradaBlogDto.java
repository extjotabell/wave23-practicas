package meli.bootcamp.spring.learning.ej10.dto.response;

import lombok.Getter;

@Getter
public class EntradaBlogDto {
  private Integer id;
  private String titulo;
  private String nombreAutor;
  private String fecha;

  public EntradaBlogDto(Integer id, String titulo, String nombreAutor, String fecha) {
    this.id = id;
    this.titulo = titulo;
    this.nombreAutor = nombreAutor;
    this.fecha = fecha;
  }

}
