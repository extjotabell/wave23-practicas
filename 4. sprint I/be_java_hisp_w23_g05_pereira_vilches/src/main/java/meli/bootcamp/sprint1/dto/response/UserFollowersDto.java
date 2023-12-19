package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFollowersDto {
    private int user_id;
    private String user_name;
    private List<UserDto> followers;
}
