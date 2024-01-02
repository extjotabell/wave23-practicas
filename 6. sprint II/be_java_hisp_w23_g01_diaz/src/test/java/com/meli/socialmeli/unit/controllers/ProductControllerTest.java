package com.meli.socialmeli.unit.controllers;

import com.meli.socialmeli.controllers.ProductController;
import com.meli.socialmeli.services.IProductService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    IProductService productService;

    @InjectMocks
    ProductController productController;
}
