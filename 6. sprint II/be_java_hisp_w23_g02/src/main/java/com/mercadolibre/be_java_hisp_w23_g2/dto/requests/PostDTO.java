package com.mercadolibre.be_java_hisp_w23_g2.dto.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductBasicDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price"})
public class PostDTO {

  @NotNull(message = "El id no puede estar vacío")
  @Positive(message = "El id debe ser mayor a cero")
  @JsonProperty("user_id")
  private Integer userId;

  @NotNull(message = "La fecha no puede estar vacía")
  @JsonDeserialize(using = LocalDateDeserializer.class)
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonFormat(pattern = "dd-MM-yyyy")
  private LocalDate date;

  @Valid
  private ProductBasicDTO product;

  @NotNull(message = "La categoría no puede estar vacía")
  private Integer category;

  @NotNull(message = "El precio no puede estar vacío")
  @Max(value = 10000000, message = "El precio máximo por producto es de 10.000.000")
  private Double price;
}
