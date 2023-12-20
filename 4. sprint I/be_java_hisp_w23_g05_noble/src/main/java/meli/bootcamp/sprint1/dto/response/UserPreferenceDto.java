package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserPreferenceDto {
    private int userId;
    private String userName;
    private int sellersFollowed, sellersWithPromo, sellersWithoutPromo;
    private String description;
}
