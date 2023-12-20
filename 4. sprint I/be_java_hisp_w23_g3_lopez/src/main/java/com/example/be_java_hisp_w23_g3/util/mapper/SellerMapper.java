package com.example.be_java_hisp_w23_g3.util.mapper;

import com.example.be_java_hisp_w23_g3.dto.response.SellerResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.user.Seller;

public class SellerMapper {

    public static SellerResponseDTO mapToDTO(Seller seller){
        return new SellerResponseDTO(seller.getId(), seller.getUsername());
    }

}
