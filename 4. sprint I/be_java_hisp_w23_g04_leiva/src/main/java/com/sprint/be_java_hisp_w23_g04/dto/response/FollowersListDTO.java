package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("userName")
    private String user_name;
    @JsonProperty("followers")
    private List<UserFollowDTO> followers;
}
