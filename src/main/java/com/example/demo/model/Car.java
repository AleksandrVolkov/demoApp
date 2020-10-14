package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private Long wheels_count;
    private Long cost;
    private String driver_name;

    public Car() {
    }

    public Car(String brand, Long wheels_count, Long cost, String driver_name) {
        this.brand = brand;
        this.wheels_count = wheels_count;
        this.cost = cost;
        this.driver_name = driver_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getWheels_count() {
        return wheels_count;
    }

    public void setWheels_count(Long wheels_count) {
        this.wheels_count = wheels_count;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }
}
