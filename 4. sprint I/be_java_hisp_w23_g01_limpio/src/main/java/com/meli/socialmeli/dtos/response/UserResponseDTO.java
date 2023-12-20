package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDTO {
    private Integer user_id;
    private String user_name;
    private List<String> followers;
    private List<String> followed;
}
