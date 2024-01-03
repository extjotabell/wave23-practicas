package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SellerDTO extends BuyerDTO {
    private List<UserDTO> followers;
    @JsonProperty("followers_count")
    private Integer followersCount;

    public SellerDTO(List<UserDTO> followed, List<UserDTO> followers, Integer followersCount) {
        super(followed);
        this.followers = followers;
        this.followersCount = followersCount;
    }

    public SellerDTO(Integer id, String name, Integer followersCount) {
        super(id, name);
        this.followersCount = followersCount;
    }
}

