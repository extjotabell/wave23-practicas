package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import meli.bootcamp.sprint1.dto.response.UserDto;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserFollowedDto {

    private Integer user_id;
    private String user_name;
    private List<UserDto> followed;

}
