package com.sprint.be_java_hisp_w23_g04.dto.response;

import lombok.*;

import java.util.List;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PostDTO extends SellerDTO {
    private List<PostResponseDTO> posts;
}
