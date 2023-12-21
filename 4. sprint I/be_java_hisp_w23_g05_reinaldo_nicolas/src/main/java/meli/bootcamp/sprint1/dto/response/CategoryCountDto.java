package meli.bootcamp.sprint1.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CategoryCountDto {
    private int user_id;
    private String user_name;
    private String category;
    private int category_post_count;
}
