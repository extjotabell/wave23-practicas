package com.example.be_java_hisp_w23_g3.repository.seller;

import com.example.be_java_hisp_w23_g3.dto.response.PostPromoResponseDTO;
import com.example.be_java_hisp_w23_g3.entity.Seller;
import com.example.be_java_hisp_w23_g3.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
    Long getPromoPostCount(Seller seller);
}
