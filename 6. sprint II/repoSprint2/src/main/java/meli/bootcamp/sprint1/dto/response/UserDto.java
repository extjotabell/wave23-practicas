package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class UserDto {
    private int user_id;
    private String user_name;
}
