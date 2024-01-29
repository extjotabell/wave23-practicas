package com.mercadolibre.starwars.controller;


import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mercadolibre.starwars.service.FindService;

@ExtendWith(MockitoExtension.class)
public class FindControllerTest {
    @Mock
    FindService service;

    @InjectMocks
    FindController controller;

    @Test
    void controllerCallServiceOnce() {
        String query = "Luke";

        controller.find(query);

        verify(service, atLeastOnce()).find(query);
    }
}