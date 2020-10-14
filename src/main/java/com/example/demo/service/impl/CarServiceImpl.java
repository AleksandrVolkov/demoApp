package com.example.demo.service.impl;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
//        List<Car> all = carRepository.findAll();
        return carRepository.findAll();
    }

//    @Override
//    public List<Car> findAllByBrand(String brand) {
//        return carRepository.findAllByBrand(brand);
//    }

//    @Override
//    public List<Car> findAllByDriver_name(String driver_name) {
//        return carRepository.findAllByDriver_name(driver_name);
//    }

    @Override
    public boolean delete(Long id) {
        Optional<Car> byId = carRepository.findById(id);
        if (byId.isPresent()) {
            carRepository.delete(byId.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean create(String brand, Long wheels_count, Long cost, String driver_name) {
        Car car = new Car(brand, wheels_count, cost, driver_name);
        carRepository.save(car);
        return true;
    }

    @Override
    public boolean update(Long id, String brand, String wheels_count, String cost, String driver_name) {
        Optional<Car> byId = carRepository.findById(id);
        if (byId.isPresent()) {
            Car car = byId.get();
            car.setBrand(brand.isEmpty() ? car.getBrand() : brand);
            car.setWheels_count(wheels_count.isEmpty() ? car.getWheels_count() : Long.parseLong(wheels_count));
            car.setCost(cost.isEmpty() ? car.getCost() : Long.parseLong(cost));
            car.setDriver_name(driver_name.isEmpty() ? car.getDriver_name() : driver_name);
            carRepository.save(car);
            return true;
        }
        return false;
    }
}
