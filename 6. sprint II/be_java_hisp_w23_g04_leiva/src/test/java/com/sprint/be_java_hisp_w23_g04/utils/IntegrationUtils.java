package com.sprint.be_java_hisp_w23_g04.utils;


import com.sprint.be_java_hisp_w23_g04.dto.request.PostDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.*;

import java.time.LocalDate;
import java.util.List;

public class IntegrationUtils {

    /**
     * Provides a ProductDTO to be used in an integration test based on the DB JSON.
     * @return ProductDTO with the expected values.
     */
    public static ProductDTO getProductDTO() {
        return new ProductDTO(1, "Silla gamer", "Gamer", "Racer", "Red", "Special Edition");
    }

    /**
     * Provides a PostDTO to be used in an integration test based on the DB JSON.
     * @return PostDTO with the expected values.
     */

    public static PostDTO getPostDTO() {
        return new PostDTO(1, LocalDate.of(2023,12,29), getProductDTO(), 100, 100.00);
    }

    /**
     * Provides all the users who are currently followers of the user with ID 1 in asc order by name
     * @return BuyerDTO containing the ID and name of the user, and a list of all their followers.
     */
    public static BuyerDTO getBuyerFollowersDTO() {
        return new BuyerDTO(1, "Juan Perez",
                List.of(
                        new UserDTO(6, "Diego Lopez"),
                        new UserDTO(4, "Sofia Gomez")
                )
        );
    }

    /**
     * Provides all the users who are currently being followed by the user with ID 4 in asc order by name.
     * @return BuyerDTO containing the ID and name of the user, and a list of all the users being followed.
     */
    public static BuyerDTO getBuyerFollowedDTO() {
        return new BuyerDTO(4, "Sofia Gomez",
                List.of(
                        new UserDTO(1, "Juan Perez"),
                        new UserDTO(3, "Pablo Gonzalez")
                )
        );
    }
}
