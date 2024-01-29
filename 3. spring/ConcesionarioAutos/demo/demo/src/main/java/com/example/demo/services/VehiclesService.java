package com.example.demo.services;

import com.example.demo.models.Car;
import com.example.demo.models.CarDTO;

import java.util.Date;
import java.util.List;

public interface VehiclesService {

    boolean addCar(Car car);

    List<CarDTO> getCars();

    List<Car> getCarsBetweenDates(Date since, Date to);

    List<Car> getCarsBetweenPrices(Double since, Double to);

    Car getCar(Long id);
}
