package com.sprint.be_java_hisp_w23_g04.controller;

import com.sprint.be_java_hisp_w23_g04.service.PostMediaServiceImpl;
import com.sprint.be_java_hisp_w23_g04.service.ProductMediaServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductsMeliControllerTest {

    @Mock
    PostMediaServiceImpl postService;

    @Mock
    ProductMediaServiceImpl productService;

    @InjectMocks
    ProductsMeliController controller;

}
