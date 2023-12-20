package com.example.be_java_hisp_w23_g3.dto.response;

import lombok.Data;

@Data
public class SellerResponseDTO extends UserResponseDTO {
    public SellerResponseDTO(Long userId, String userName) {
        super(userId, userName);
    }
}
