package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostFollowedDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PromoCountDTO;

import java.time.LocalDate;

public interface IProductService {
    MessageDTO addNormalPost(PostDTO postRequestDTO);
    MessageDTO addPromoPost(PostDTO postRequestDTO);
    PromoCountDTO getPromoCount(int UserId);
    PostFollowedDTO getFilteredPosts(int userId, LocalDate minDate, LocalDate maxDate, Double minPrice, Double maxPrice, String name, String brand);
}
