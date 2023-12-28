package meli.bootcamp.sprint1.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomException {
  private String explanation;
  private List<String> message;
}
