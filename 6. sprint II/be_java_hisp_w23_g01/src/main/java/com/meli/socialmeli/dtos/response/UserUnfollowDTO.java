package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUnfollowDTO {
    @NotNull(message = "El  campo 'user_id' no puede estar vacío.")
    @Min(value= 1, message= "El campo 'user_id' debe ser mayor a cero")
    private int userId;
    @Min(value= 1, message= "El campo 'userIdToUnfollow' debe ser mayor a cero")
    private int userIdToUnfollow;
}
