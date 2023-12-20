package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.response.SellerDTO;
import com.example.be_java_hisp_w23_g3.entity.Seller;

public class SellerMapper {

    public static SellerDTO mapToDTO(Seller seller){
        return new SellerDTO(seller.getId(), seller.getUsername());
    }

}
