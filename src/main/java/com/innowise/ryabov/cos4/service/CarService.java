package com.innowise.ryabov.cos4.service;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.entity.Car;
import com.innowise.ryabov.cos4.request.CarRequest;

import java.util.List;

public interface CarService {
    List<CarDTO> getAllCars();
    CarDTO getCar(Long id);
    void saveCar(Car car);
    CarDTO updateCar(Long id, CarRequest carDetails);
    void deleteCar(Long id);
}
