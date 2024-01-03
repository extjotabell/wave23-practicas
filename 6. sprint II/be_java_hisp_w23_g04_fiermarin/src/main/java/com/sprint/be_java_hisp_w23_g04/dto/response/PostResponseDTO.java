package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Generated
public class PostResponseDTO extends PostDTO {
    @JsonProperty("post_id")
    private int postId;

    public PostResponseDTO(int userId, int postId, LocalDate date, ProductDTO product, int category, double price) {
        super(userId, date, product, category, price);
        this.postId = postId;
    }
}

