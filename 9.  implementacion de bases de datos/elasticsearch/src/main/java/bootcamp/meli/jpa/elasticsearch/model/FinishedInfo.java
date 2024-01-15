package bootcamp.meli.jpa.elasticsearch.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FinishedInfo {
  private String workerName;
  private String finishedAt;
}
