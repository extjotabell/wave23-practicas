package meli.bootcamp.sprint1.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LastPostsDto {
  private int user_id;
  private List<PostDto> posts;
}
