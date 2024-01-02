package com.meli.socialmeli.dtos.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.meli.socialmeli.dtos.response.ProductDTO;
import com.meli.socialmeli.utilities.CustomLocalDateDeserializer;
import com.meli.socialmeli.utilities.CustomLocalDateValidation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    @JsonProperty("user_id")
    @NotNull(message = "El campo 'user_id' no puede estar vacío.")
    @Min( value= 1, message= "El campo 'user_id' debe ser mayor a cero")
    Integer userId;
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    @NotNull(message = "El campo 'date' no puede estar vacío.")
    @CustomLocalDateValidation(message = "Fecha inválida. El formato debe ser yyyy-MM-dd")
    protected LocalDate date;
    @NotNull(message = "El campo 'product' no puede estar vacío.")
    protected @Valid ProductDTO product;
    @NotNull(message = "El campo 'category' no puede estar vacío.")
    protected Integer category;
    @NotNull(message = "El  campo 'price' no puede estar vacío.")
    @DecimalMin(value="0", message= "El precio mínimo por producto es de 0")
    @DecimalMax(value="10000000", message= "El precio máximo por producto es de 10.000.000")
    protected Double price;
}

