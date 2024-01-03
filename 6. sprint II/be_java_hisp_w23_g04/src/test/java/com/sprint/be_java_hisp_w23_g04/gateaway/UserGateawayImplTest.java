package com.sprint.be_java_hisp_w23_g04.gateaway;

import com.sprint.be_java_hisp_w23_g04.gateway.UserGatewayImpl;
import com.sprint.be_java_hisp_w23_g04.repository.UserMediaRepositoryImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserGateawayImplTest {

    @Mock
    UserMediaRepositoryImpl userMediaRepository;

    @InjectMocks
    UserGatewayImpl userGateway;
}
