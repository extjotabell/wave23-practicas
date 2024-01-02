package com.mercadolibre.be_java_hisp_w23_g2.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostBasicDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "posts"})
public class PostsFollowedDTO {

  @JsonProperty("user_id")
  private Integer id;
  private List<PostBasicDTO> posts;
}
