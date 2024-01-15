package bootcamp.meli.jpa.elasticsearch.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewWorkDto {
  private String description;
  private String createdAt;
}
