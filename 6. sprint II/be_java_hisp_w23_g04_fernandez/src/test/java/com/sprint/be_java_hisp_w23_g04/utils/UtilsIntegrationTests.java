package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.response.BuyerDTO;
import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;

import java.util.List;

public class UtilsIntegrationTests {

    public static BuyerDTO getBuyerDTOTestUS0003(String order) {
        UserDTO user1 = new UserDTO(6,"Diego Lopez");
        UserDTO user2 = new UserDTO(4,"Sofia Gomez");

        if(order.equals("name_dsc")) {
            return new BuyerDTO(1,"Juan Perez",List.of(user2,user1));
        }

        return new BuyerDTO(1,"Juan Perez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTestUS0003() {
        UserDTO user1 = new UserDTO(6,"Diego Lopez");
        UserDTO user2 = new UserDTO(4,"Sofia Gomez");

        return new BuyerDTO(1,"Juan Perez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTestUS0004(String order) {
        UserDTO user1 = new UserDTO(1,"Juan Perez");
        UserDTO user2 = new UserDTO(3,"Pablo Gonzalez");

        if(order.equals("name_dsc")) {
            return new BuyerDTO(4,"Sofia Gomez",List.of(user2,user1));
        }

        return new BuyerDTO(4,"Sofia Gomez",List.of(user1,user2));
    }

    public static BuyerDTO getBuyerDTOTestUS0004() {
        UserDTO user1 = new UserDTO(1,"Juan Perez");
        UserDTO user2 = new UserDTO(3,"Pablo Gonzalez");

        return new BuyerDTO(4,"Sofia Gomez",List.of(user1,user2));
    }
}
