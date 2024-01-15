package bootcamp.meli.jpa.elasticsearch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkInfoDto {
  private String id;
  private String description;
  private String createdAt;
  private FinishedInfoDto finishedInfo;
}
