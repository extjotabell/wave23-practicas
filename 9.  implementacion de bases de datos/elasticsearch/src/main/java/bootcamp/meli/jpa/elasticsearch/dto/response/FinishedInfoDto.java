package bootcamp.meli.jpa.elasticsearch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FinishedInfoDto {
  private String workerName;
  private String finishedAt;
}
