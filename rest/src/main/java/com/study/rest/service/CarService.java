package com.study.rest.service;

import com.study.rest.entity.Car;
import com.study.rest.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    // final (상수) : 무조건 한번은 초기화를 해줘야 한다.(강제성) == NonNull
    // private final CarRepository carRepository;
    // private final String name;
    @Autowired // CarRepository에서 car를 가져와야댐
    private CarRepository carRepository;
    
    // 외부에서 주입 (Autowired)
//    public CarService(CarRepository carRepository){
//        this.carRepository = carRepository;  자기자신의 값을 멤버변수로 값을 대입
//        this.name = "김준일"
//    }

    // 동일한 이름을 쓰면
//    public CarService() {
//
//    }

    public Car getCar(String model) {
        return carRepository.findCarByModel(model);
    }

}

