package com.mercadolibre.be_java_hisp_w23_g2.service;

import com.mercadolibre.be_java_hisp_w23_g2.dto.MessageDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.PostDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductsPromCountDTO;

public interface IProductService {
    MessageDTO addPost(PostDTO postDTO);
    MessageDTO addPromoPost(PostDTO postDTO);
    ProductsPromCountDTO getProductsPromCount(int userId);
}
