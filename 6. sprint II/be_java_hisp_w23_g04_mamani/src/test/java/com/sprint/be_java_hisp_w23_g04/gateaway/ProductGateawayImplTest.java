package com.sprint.be_java_hisp_w23_g04.gateaway;

import com.sprint.be_java_hisp_w23_g04.gateway.ProductGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.repository.ProductMediaRepositoryImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductGateawayImplTest {

    @Mock
    ProductMediaRepositoryImpl productRepository;

    @InjectMocks
    ProductGatewayImpl productGateway;

}
