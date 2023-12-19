package com.ospina.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class PromoPostsFromSellerListDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_name")
    private String userName;
    private List<PostPromoResponseDTO> posts;

}
