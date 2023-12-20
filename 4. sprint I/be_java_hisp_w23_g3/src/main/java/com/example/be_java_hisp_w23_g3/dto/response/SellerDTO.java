package com.example.be_java_hisp_w23_g3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SellerDTO extends UserDTO {
    public SellerDTO(Long userId, String userName) {
        super(userId, userName);
    }
}
