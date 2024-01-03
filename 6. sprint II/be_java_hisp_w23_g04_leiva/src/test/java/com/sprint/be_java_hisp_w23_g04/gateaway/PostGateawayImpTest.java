package com.sprint.be_java_hisp_w23_g04.gateaway;

import com.sprint.be_java_hisp_w23_g04.gateway.PostGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.repository.PostMediaRepositoryImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
@ExtendWith(MockitoExtension.class)
public class PostGateawayImpTest {
    @Mock
    PostMediaRepositoryImpl postRepository;

    @InjectMocks
    PostGatewayImpl postGateway;

}
