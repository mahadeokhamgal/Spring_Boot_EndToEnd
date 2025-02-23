package com.mahadeo.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {

    
    private final Car car;

    // @Autowired - deprecated from Spring 4.3
    public MyClass(Car car) {
        this.car = car;
    }

    @GetMapping("hello")
    public String sayHello() {
        return this.car.getCar() + " and Hello";
    }
}
