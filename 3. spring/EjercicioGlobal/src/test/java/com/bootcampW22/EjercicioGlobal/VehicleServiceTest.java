package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static com.bootcampW22.EjercicioGlobal.util.ObjectFactory.getVehicleDtoList;
import static com.bootcampW22.EjercicioGlobal.util.ObjectFactory.getVehicleList;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

    @Mock
    VehicleRepositoryImpl vehicleRepository;

    @InjectMocks
    VehicleServiceImpl vehicleService;

    @Test
    void buscarColoryear(){
        //ARRANGE
        String color = "red";
        int year = 1998;
        List<Vehicle> returnMockRepo = getVehicleList();
        List<VehicleDto> expected = getVehicleDtoList();

        when(vehicleRepository.buscarColoryear(anyString(),anyInt())).thenReturn(returnMockRepo);

        //ACT
        List<VehicleDto> actual = vehicleService.buscarColoryear(color,year);

        //ASSERT
        Assertions.assertEquals(expected,actual);
    }
}
