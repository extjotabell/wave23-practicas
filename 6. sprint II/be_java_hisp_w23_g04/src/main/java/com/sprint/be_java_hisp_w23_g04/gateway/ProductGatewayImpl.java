package com.sprint.be_java_hisp_w23_g04.gateway;

import com.sprint.be_java_hisp_w23_g04.entity.Product;
import com.sprint.be_java_hisp_w23_g04.repository.IProductMediaRepository;
import com.sprint.be_java_hisp_w23_g04.repository.ProductMediaRepositoryImpl;
import org.springframework.stereotype.Component;

@Component
public class ProductGatewayImpl implements  IProductGateway{

    IProductMediaRepository productRepository;

    public ProductGatewayImpl(ProductMediaRepositoryImpl productRepository){
        this.productRepository = productRepository;
    }

    /**
     * Get posts by list ids
     *
     * @param id id of the product to get.
     * @return the Product
     **/
    @Override
    public Product getById(Integer id) {
        return this.productRepository.getById(id);
    }
}
