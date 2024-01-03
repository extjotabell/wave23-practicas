package meli.bootcamp.sprint1.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class LastPostsDto {
  private int user_id;
  private List<PostDto> posts;
}
