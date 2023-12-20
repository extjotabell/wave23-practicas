package com.example.be_java_hisp_w23_g3.dto.request;

import com.example.be_java_hisp_w23_g3.dto.response.UserResponseDTO;

public class SellerRequestDTO extends UserResponseDTO {
    public SellerRequestDTO(Long userId, String userName) {
        super(userId, userName);
    }
}
