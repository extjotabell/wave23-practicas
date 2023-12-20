package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowersDTO {
    private int user_id;
    private String user_name;
    private List<UserInfoDTO> followers;
}
