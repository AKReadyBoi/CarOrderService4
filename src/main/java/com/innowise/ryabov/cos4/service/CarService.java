package com.innowise.ryabov.cos4.service;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.request.CarRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public interface CarService {
    List<CarDTO> getAllCars();
    void saveCar(CarRequest car);
    CarDTO updateCar(Long id, CarRequest carRequest);
    void deleteCar(Long id);
    CarDTO getCar(Long id);
}