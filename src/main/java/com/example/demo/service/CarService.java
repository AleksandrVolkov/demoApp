package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

//    List<Car> findAllByBrand(String brand);
//
//    List<Car> findAllByDriver_name(String driver_name);

    boolean delete(Long id);

    boolean create(String brand, Long wheels_count, Long cost, String driver_name);

    boolean update(Long id, String brand, String wheels_count, String cost, String driver_name);
}
