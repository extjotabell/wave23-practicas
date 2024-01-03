package com.sprint.be_java_hisp_w23_g04.dto.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Generated
public class PostDTO extends SellerDTO {
    private List<PostResponseDTO> posts;
}
