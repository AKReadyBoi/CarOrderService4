package com.innowise.ryabov.cos4.mapper;

import com.innowise.ryabov.cos4.dto.CarDTO;
import com.innowise.ryabov.cos4.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDTO carToCarDTO(Car car);
}
