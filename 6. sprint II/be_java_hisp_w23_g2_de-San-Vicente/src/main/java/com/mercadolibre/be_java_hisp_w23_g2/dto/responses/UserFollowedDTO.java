package com.mercadolibre.be_java_hisp_w23_g2.dto.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mercadolibre.be_java_hisp_w23_g2.dto.UserBasicDTO;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({"user_id", "user_name", "followed"})
public class UserFollowedDTO {

  @JsonProperty("user_id")
  private Integer id;
  @JsonProperty("user_name")
  private String userName;
  private List<UserBasicDTO> followed;
}
