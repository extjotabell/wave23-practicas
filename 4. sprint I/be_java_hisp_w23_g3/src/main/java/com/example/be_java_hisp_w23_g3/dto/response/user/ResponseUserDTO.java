package com.example.be_java_hisp_w23_g3.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseUserDTO {
    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("user_name")
    private String userName;

    public ResponseUserDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}
