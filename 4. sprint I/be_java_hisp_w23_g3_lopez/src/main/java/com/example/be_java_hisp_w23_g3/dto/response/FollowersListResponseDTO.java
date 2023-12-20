package com.example.be_java_hisp_w23_g3.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowersListResponseDTO {

    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("followers")
    private List<UserResponseDTO> followers;

}
