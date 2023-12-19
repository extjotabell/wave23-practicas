package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.response.SellerDTO;
import com.ospina.socialmeli.entity.Seller;

public class SellerMapper {

    public static SellerDTO mapToDTO(Seller seller){
        return new SellerDTO(seller.getId(), seller.getUsername());
    }

}
