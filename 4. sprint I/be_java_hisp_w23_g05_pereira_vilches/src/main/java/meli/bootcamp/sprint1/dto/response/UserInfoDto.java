package meli.bootcamp.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.bootcamp.sprint1.entity.Post;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoDto {
    private int id;
    private String name;
    @JsonAlias("isSeller")
    private boolean isSeller;
    private List<Post> posts;
    private List<Integer> followed;
    private List<Integer> followers;
    private List<Post> favorites;
}
