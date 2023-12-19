package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class UserPromoPostResponseDTO {

    private Integer user_id;
    private String user_name;
    private List<PromoPostResponseDTO> posts;
}
