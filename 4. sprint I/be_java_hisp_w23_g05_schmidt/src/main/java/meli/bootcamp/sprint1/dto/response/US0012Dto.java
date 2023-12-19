package meli.bootcamp.sprint1.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class US0012Dto {
    private String user_name;
    private List<PostDto> posts;
}
