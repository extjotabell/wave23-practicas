package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUnfollowDTO {
    private int userId;
    private int userIdToUnfollow;
}
