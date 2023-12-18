package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FollowersDto {
  private int user_id;
  private String user_name;
  private int followers_count;
}
