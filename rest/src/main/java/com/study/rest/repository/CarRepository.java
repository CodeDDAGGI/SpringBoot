
package com.study.rest.repository;

import com.study.rest.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.study.rest.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepository {

    // 전역변수로 만듬
    private  List<Car> carList = List.of(
            Car.builder().model("쏘나타").color("화이트").build(),
            Car.builder().model("K5").color("블랙").build()
    );

    Car findCar = null;

    public Car findCarByModel(String model){
        // return carList.stream()
        //      .filter(car -> car.getModel().equals(model))
        //      .collect(Collectors.toList())
        //      .get(0)

        for(Car car : carList){
            if(car.getModel().equals(model)) {
                findCar = car;
            }
        }
        return findCar;

    }
}
