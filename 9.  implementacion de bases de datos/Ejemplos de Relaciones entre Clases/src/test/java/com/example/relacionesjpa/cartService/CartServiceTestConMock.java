package com.example.relacionesjpa.cartService;

import com.example.relacionesjpa.repository.CartRepository;
import com.example.relacionesjpa.service.CartServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CartServiceTestConMock {

    @Mock
    CartRepository cartRepository;

    @InjectMocks
    CartServiceImp serviceImp;

    @Test
    void buscarPorIdOk(){

    }
}
