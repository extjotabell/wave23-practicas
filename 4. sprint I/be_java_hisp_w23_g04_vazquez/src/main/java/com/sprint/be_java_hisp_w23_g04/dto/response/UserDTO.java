package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @JsonProperty("user_id")
    private int id;
    private String name;
    private List<PostResponseDTO> posts;
    private List<UserFollowDTO> followed;
    private List<UserFollowDTO> followers;
}
