package com.sprint.be_java_hisp_w23_g04.utils;

import com.sprint.be_java_hisp_w23_g04.dto.response.UserDTO;
import com.sprint.be_java_hisp_w23_g04.entity.User;


public class UserMapper {

    public static UserDTO mapUser(User user) {
        return new UserDTO(user.getId(), user.getName());
    }

}
