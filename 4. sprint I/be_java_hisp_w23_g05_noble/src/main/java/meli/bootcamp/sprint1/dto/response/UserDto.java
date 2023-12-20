package meli.bootcamp.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private int id;
    private String name;
    @JsonAlias("isSeller")
    private boolean isSeller;
    private List<PostDto> posts;
    private List<Integer> followed;
    private List<Integer> followers;
}
