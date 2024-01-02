package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;

import java.util.List;
import java.util.Objects;

public class UtilsIntegrationTests {

    public static BuyerDTO getBuyerDTOTest(String order) {
        UserDTO user1 = new UserDTO(6,"Diego Lopez");
        UserDTO user2 = new UserDTO(4,"Sofia Gomez");

        if(order.equals("name_dsc")) {
            return new BuyerDTO(1,"Juan Perez",List.of(user2,user1));
        }

        return new BuyerDTO(1,"Juan Perez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTest() {
        UserDTO user1 = new UserDTO(6,"Diego Lopez");
        UserDTO user2 = new UserDTO(4,"Sofia Gomez");

        return new BuyerDTO(1,"Juan Perez",List.of(user1,user2));
    }
}
