package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import lombok.*;


import java.time.LocalDate;
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PostResponseDTO extends PostDTO {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public PostResponseDTO(int userId, int postId, LocalDate date, ProductDTO product, int category, double price) {
        super(userId, date, product, category, price);
        this.postId = postId;
    }


    public PostResponseDTO(int userId, LocalDate date, ProductDTO product, int category, double price, int postId, boolean hasPromo, double discount) {
        super(userId, date, product, category, price);
        this.postId = postId;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}

