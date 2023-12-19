package com.ospina.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class SellerDTO extends UserDTO {
    public SellerDTO(Long userId, String userName) {
        super(userId, userName);
    }
}
