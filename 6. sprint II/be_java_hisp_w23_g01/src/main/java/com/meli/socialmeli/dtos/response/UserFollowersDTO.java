package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserFollowersDTO {
    @NotNull(message = "El  campo 'user_id' no puede estar vacío.")
    @Min(value= 1, message= "El campo 'user_id' debe ser mayor a cero")
    private int user_id;
    @Size(max=15, message = "La longitud del campo 'user_name' no puede ser mayor a 15")
    private String user_name;
    private List< @Valid UserInfoDTO> followers;
}
