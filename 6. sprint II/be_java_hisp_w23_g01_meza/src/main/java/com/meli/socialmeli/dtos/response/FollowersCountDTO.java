package com.meli.socialmeli.dtos.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FollowersCountDTO {
    @NotNull(message = "El  campo 'user_id' no puede estar vacío.")
    @Min(value= 1, message= "El campo 'user_id' debe ser mayor a cero")
    private Integer user_id;
    @Size(max=15, message = "La longitud del campo 'user_name' no puede ser mayor a 15")
    private String user_name;
    private int followers_count;
}
