package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.*;

import java.util.List;

public interface IPostService {
    MessageDTO addPostPromo(PostPromoDTO postPromoDTO);
    UserPromoCountDTO getPromoCountSeller(int userId);
    PostPromoListDTO getPostsPromoByCategory(String category);
}
