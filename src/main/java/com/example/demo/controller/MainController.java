package com.example.demo.controller;

import com.example.demo.service.CarService;
import com.example.demo.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private CarService carService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        model.put("cars", carService.getAll());
        return "main";
    }

    private static boolean allCarParamsIsNull(String brand, String wheels_count, String cost, String driver_name) {
        return !((brand != null && !brand.isEmpty()) ||
                (wheels_count != null && !wheels_count.isEmpty()) ||
                (cost != null && !cost.isEmpty()) ||
                (driver_name != null && !driver_name.isEmpty()));
    }

    @PostMapping("/create")
    public String create(Map<String, Object> model,
                         @RequestParam String brand,
                         @RequestParam String wheels_count,
                         @RequestParam String cost,
                         @RequestParam String driver_name) {
        boolean sdsa = !allCarParamsIsNull(brand, wheels_count, cost, driver_name);

        if (!allCarParamsIsNull(brand, wheels_count, cost, driver_name))
            carService.create(brand,
                    Long.parseLong(wheels_count),
                    Long.parseLong(cost),
                    driver_name);

        model.put("cars", carService.getAll());
        return "main";
    }

    @PostMapping("/delete")
    public String remove(@RequestParam String id, Map<String, Object> model) {
        carService.delete(Long.parseLong(id));
        model.put("cars", carService.getAll());
        return "main";
    }

    @PostMapping("/update")
    public String edit(Map<String, Object> model,
                       @RequestParam String id,
                       @RequestParam String brand,
                       @RequestParam String wheels_count,
                       @RequestParam String cost,
                       @RequestParam String driver_name) {
        boolean sdsa = !allCarParamsIsNull(brand, wheels_count, cost, driver_name);
        if ((id != null && !id.isEmpty()) && !allCarParamsIsNull(brand, wheels_count, cost, driver_name))
            carService.update(Long.parseLong(id), brand, wheels_count, cost, driver_name);

        model.put("cars", carService.getAll());
        return "main";
    }
}
