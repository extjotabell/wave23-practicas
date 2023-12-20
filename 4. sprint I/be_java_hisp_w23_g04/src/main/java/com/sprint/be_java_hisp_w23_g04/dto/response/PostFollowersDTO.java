package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFollowersDTO {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("posts")
    private List<PostResponseDTO> posts;
}
