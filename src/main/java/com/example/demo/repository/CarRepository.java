package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
//    List<Car> findAllByBrand(String brand);

//    List<Car> findAllByDriver_name(String driver_name);
}
