package com.example.be_java_hisp_w23_g3.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserRequestDTO {
    @JsonProperty("user_name")
    private String userName;
}
