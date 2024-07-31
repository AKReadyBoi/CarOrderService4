package com.innowise.ryabov.cos4.service.impl;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.entity.Car;
import com.innowise.ryabov.cos4.mapper.CarMapper;
import com.innowise.ryabov.cos4.repository.CarRepository;
import com.innowise.ryabov.cos4.request.CarRequest;
import com.innowise.ryabov.cos4.util.CarNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarServiceImplTest {
    @Mock
    CarRepository carRepository;
    @Mock
    CarMapper mapper;
    @InjectMocks
    CarServiceImpl carService;
    @Test
    void getAllCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());

        when(carRepository.findAll()).thenReturn(cars);
        when(mapper.carToCarDTO(Mockito.any(Car.class))).thenReturn(new CarDTO());

        assertNotNull(carService.getAllCars());
    }

    @Test
    void saveCar() {
        CarRequest request = new CarRequest(null,
                                            null,
                                    null,
                                       null,
                                           null);

        when(mapper.carRequestToCar(request)).thenReturn(new Car());

        carService.saveCar(request);

        verify(carRepository, times(1)).save(new Car());
    }

    @Test
    void updateCar() {
        Long id = 1L;
        CarRequest request = new CarRequest("brand",
                "model",
                null,
                "plateNumber",
                null);
        Car car = new Car();

        when(carRepository.findById(Mockito.any())).thenReturn(Optional.of(car));

        carService.updateCar(id, request);

        assertEquals(request.brand(), car.getBrand());
        assertEquals(request.model(), car.getModel());
        assertEquals(request.plateNumber(), car.getPlateNumber());
        assertEquals(request.dailyFee(), car.getDailyFee());

    }

    @Test
    void deleteCar() {
        Long id = 1L;
        Car car = new Car();

        when(carRepository.findById(Mockito.any())).thenReturn(Optional.of(car));

        carService.deleteCar(id);

        verify(carRepository, times(1)).deleteById(car.getId());
    }

    @Test
    void getCar() {
        Long id = 1L;
        Car car = new Car();

        when(mapper.carToCarDTO(any(Car.class))).thenReturn(new CarDTO());
        when(carRepository.findById(Mockito.any())).thenReturn(Optional.of(car));

        carService.getCar(id);

        verify(carRepository, times(1)).findById(id);
    }
    @Test
    void deleteCar_ThrowsCarNotFoundException() {
        Long id = 1L;

        when(carRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.deleteCar(id));
    }
    @Test
    void updateCar_ThrowsCarNotFoundException() {
        Long id = 1L;
        CarRequest request = new CarRequest(null,
                null,
                null,
                null,
                null
        );

        when(carRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.updateCar(id,request));
    }
    @Test
    void getCar_ThrowsCarNotFoundException() {
        Long id = 1L;

        when(carRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CarNotFoundException.class, () -> carService.getCar(id));
    }
}