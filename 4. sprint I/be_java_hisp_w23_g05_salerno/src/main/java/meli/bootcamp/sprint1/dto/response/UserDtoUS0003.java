package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoUS0003 {
    private int user_id;
    private String user_name;
    private List<FollowersDtoUS0003> followers;
}
