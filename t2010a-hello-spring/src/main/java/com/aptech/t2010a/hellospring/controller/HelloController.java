package com.aptech.t2010a.hellospring.controller;

import com.aptech.t2010a.hellospring.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "api/hello")

public class HelloController {
    @RequestMapping(path="math", method = RequestMethod.GET)
    public double random() {
        return Math.random();
    }

    @RequestMapping(path="hi", method = RequestMethod.GET)
    public String greeting() {
        return ("Talk to world");
    }

    @RequestMapping(path = "student", method = RequestMethod.GET)
    public Student getStudent() {
        return Student.builder()
                .rollNumber("A001")
                .fullName("Hong Xuan")
                .phone("098999")
                .address("Ha Noi, Viet Nam")
                .dob(LocalDateTime.of(2007, 10, 10, 9, 0))
                .build();
    }
}
