package com.mercadolibre.be_java_hisp_w23_g2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserMaxFollowersListDTO extends UserMaxFollowersDTO{
    @JsonProperty("followers_users")
    private List<UserMaxFollowersSimpleDTO> followersUsers;

    public UserMaxFollowersListDTO(List<UserMaxFollowersSimpleDTO> followersUsers) {
        this.followersUsers = followersUsers;
    }
}
