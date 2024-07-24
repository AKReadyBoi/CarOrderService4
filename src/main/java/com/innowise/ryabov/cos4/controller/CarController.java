package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.request.CarRequest;
import com.innowise.ryabov.cos4.service.CarService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@RequestMapping("/cars")
public class CarController {
    CarService carService;
    @GetMapping("/get")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCar(id));
    }
    @PostMapping("/save")
    public ResponseEntity<HttpStatus> saveUser(@RequestBody CarRequest car) {
        carService.saveCar(car);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarRequest carDetails) {
        CarDTO car = carService.updateCar(id, carDetails);
        return ResponseEntity.ok(car);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

}
