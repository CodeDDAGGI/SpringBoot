
package com.study.rest.controller;

import com.study.rest.entity.Car;
import com.study.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @ResponseBody
    @GetMapping("/car")
    private Car getCar(@RequestParam String model) {
       return carService.getCar(model);
    }
}

/*
*  요청 GET - /car?model=K5
*  CarEntity        -> model, color
*  CarRepository    -> Car findCarByMode(String model)
*       -> List<Car>
            -> index0: Car(model: "쏘나타" , color: "화이트")
*           -> index1: Car(model: "k5", color : "블랙")
*  CarService       -> Car getCar(String model)
*  CarController    -> Car getCar(@RequestParam String model)
*  CarController(3) > CarService(2) > CarRepositrory(1)
*  의존성이 없는거 위주로 만듬
* */
