package com.innowise.ryabov.cos4.controller;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.entity.Car;
import com.innowise.ryabov.cos4.request.CarRequest;
import com.innowise.ryabov.cos4.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    CarService service;
    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }
    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCar(id));
    }
    @PostMapping("/add")
    public ResponseEntity<Void> saveCar(@RequestBody Car carDetails) {
        service.saveCar(carDetails);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarRequest car) {
        return ResponseEntity.ok(service.updateCar(id, car));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        service.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
