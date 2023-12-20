package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostPromoDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PromoProductCountDTO;

import java.util.List;

public interface IProductService {
    MessageDTO addPost(PostDTO postDTO);
    MessageDTO addPostPromo(PostPromoDTO postDTO);
    PromoProductCountDTO getPromoProductCountByUser(int userId);
    List<PostPromoDTO> searchPostsByCategory(String keyword);
}
