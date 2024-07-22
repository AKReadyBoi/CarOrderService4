package com.innowise.ryabov.cos4.service.impl;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.entity.Car;
import com.innowise.ryabov.cos4.mapper.CarMapper;
import com.innowise.ryabov.cos4.messages.PropertyUtil;
import com.innowise.ryabov.cos4.repository.CarRepository;
import com.innowise.ryabov.cos4.request.CarRequest;
import com.innowise.ryabov.cos4.service.CarService;
import com.innowise.ryabov.cos4.util.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import java.util.List;
@Transactional
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
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
    public CarDTO getCar(Long id) {
        return mapper.carToCarDTO(carRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(PropertyUtil.USER_NOT_FOUND_MESSAGE)
                ));
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public CarDTO updateCar(Long id, CarRequest carDetails) {
        CarDTO carDTO = getCar(id);
        carDTO.setBrand(carDetails.brand());
        carDTO.setModel(carDetails.model());
        carDTO.setYearOfProduction(carDetails.yearOfProduction());
        carDTO.setPlateNumber(carDetails.plateNumber());
        carDTO.setDailyFee(carDetails.dailyFee());
        return carDTO;
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(PropertyUtil.USER_NOT_FOUND_MESSAGE)
                );
        carRepository.deleteById(car.getId());
    }
}
