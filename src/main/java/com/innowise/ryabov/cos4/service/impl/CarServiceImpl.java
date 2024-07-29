package com.innowise.ryabov.cos4.service.impl;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.entity.Car;
import com.innowise.ryabov.cos4.mapper.CarMapper;
import com.innowise.ryabov.cos4.messages.PropertyUtil;
import com.innowise.ryabov.cos4.repository.CarRepository;
import com.innowise.ryabov.cos4.request.CarRequest;
import com.innowise.ryabov.cos4.service.CarService;
import com.innowise.ryabov.cos4.util.CarNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Transactional
@Service
@AllArgsConstructor
@Validated
public class CarServiceImpl implements CarService {
    CarRepository carRepository;
    CarMapper mapper;
    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.findAll()
                .stream()
                .map(mapper::carToCarDTO)
                .toList();
    }

    @Override
    public void saveCar(CarRequest car) {
        carRepository.save(mapper.carRequestToCar(car));
    }

    @Override
    public CarDTO updateCar(Long id, CarRequest carRequest) {
        Car car = findSafe(id);
        car.setBrand(carRequest.brand());
        car.setModel(carRequest.model());
        car.setPlateNumber(carRequest.plateNumber());
        car.setYearOfProduction(carRequest.yearOfProduction());
        car.setDailyFee(carRequest.dailyFee());
        return mapper.carToCarDTO(car);
    }

    @Override
    public void deleteCar(Long id) {
        val user = findSafe(id);
        carRepository.deleteById(user.getId());
    }

    @Override
    public CarDTO getCar(Long id) {
        return mapper.carToCarDTO(findSafe(id));
    }

    private Car findSafe(Long id) {
        return carRepository.findById(id)
                .orElseThrow(
                        () -> new CarNotFoundException(PropertyUtil.CAR_NOT_FOUND_MESSAGE)
                );
    }
}
