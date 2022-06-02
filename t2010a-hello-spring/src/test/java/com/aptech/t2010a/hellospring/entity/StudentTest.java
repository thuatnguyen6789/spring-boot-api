package com.aptech.t2010a.hellospring.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    @Test
    public void testCreateStudent() {
        Student student = new Student();
        student.setRollNumber("A001");
        student.setFullName("Xuan Hung");
        student.setAddress("Hanoi");
        System.out.println(student.toString());

        System.out.println(Student.builder()
                .rollNumber("A002")
                .fullName("Xuan Ha")
                .address("Hatay")
                .phone("09888")
                .build().toString());
    }
}