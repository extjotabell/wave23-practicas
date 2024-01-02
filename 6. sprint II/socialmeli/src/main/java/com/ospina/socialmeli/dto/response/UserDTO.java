package com.ospina.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
}
