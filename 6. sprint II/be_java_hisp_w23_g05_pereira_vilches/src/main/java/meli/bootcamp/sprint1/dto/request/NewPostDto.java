package meli.bootcamp.sprint1.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewPostDto {
  @NotNull(message = "El id no puede estar vacio.")
  @Min(value = 1,message = "El id debe ser mayor a 0.")
  private int user_id;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  @NotNull(message = "La fecha no puede estar vacia.")
  private LocalDate date;

  @Valid
  private NewProductDto product;

  @NotNull(message = "La categoria no puede estar vacia.")
  private int category;


  @NotNull(message = "El campo price no puede estar vacio.")
  @DecimalMax(message = "El precio maximo por producto es de 10.000.000",value = "10000000.0")
  private double price;
}