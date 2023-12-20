package com.meli.socialmeli.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserSellersSuggestedDTO {
    private int user_id;
    private String user_name;
    private List<UserInfoDTO> suggested_sellers;
}