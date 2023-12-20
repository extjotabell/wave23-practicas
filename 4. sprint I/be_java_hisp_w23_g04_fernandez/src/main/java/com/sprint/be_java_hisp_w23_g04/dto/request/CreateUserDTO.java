package com.sprint.be_java_hisp_w23_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w23_g04.dto.response.PostResponseDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserFollowDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDTO {
    @JsonProperty("name")
    private String name;
}
