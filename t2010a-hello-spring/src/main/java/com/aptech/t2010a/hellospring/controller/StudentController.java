package com.aptech.t2010a.hellospring.controller;

import com.aptech.t2010a.hellospring.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/*
http://localhost:8888/api/v1/students   |  GET     |  return list student
http://localhost:8888/api/v1/students   |  POST    |  create new student
http://localhost:8888/api/v1/students/1   |  DELETE  |  remove student by id=1
http://localhost:8888/api/v1/students/1   | GET    |  find student by id=1
http://localhost:8888/api/v1/students/1   | PUT    | update student by id=1
 */

@RestController
@RequestMapping(path="api/v1/students")

public class StudentController {
    private static List<Student> list;
    public StudentController() {
        list = new ArrayList<>();
        list.add(Student.builder().rollNumber("A001").fullName("Xuan Thuat").build());
        list.add(Student.builder().rollNumber("A002").fullName("Xuan Thao").build());
        list.add(Student.builder().rollNumber("A003").fullName("Xuan Nhien").build());
        list.add(Student.builder().rollNumber("A004").fullName("Xuan My").build());
        list.add(Student.builder().rollNumber("A005").fullName("Xuan La").build());
    }
    //CRUD
    @RequestMapping(method = RequestMethod.GET)
    public List<Student> findAll() {
        return list;
    }

    //path variable
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public Student findById(@PathVariable String id)
    {
        int foundIndex = -1;
        for(int i=0; i<list.size(); i++){
           if(list.get(i).getRollNumber().equals(id)){
               foundIndex = i;
               break;
           }
        }
        if(foundIndex == -1){
            return null;
        }
        return list.get(foundIndex);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student) {
        list.add(student);
        return student;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "{id}")
    public boolean deleteById(@PathVariable String id) {
        int foundIndex = -1;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if(foundIndex == -1){
            return false;
        }
        list.remove(foundIndex);
        return true;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public Student update(@PathVariable String id, @RequestBody Student updateStudent) {
        int foundIndex = -1;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i).getRollNumber().equals(id)){
                foundIndex = i;
                break;
            }
        }
        if(foundIndex == -1){
            return null;
        }
        Student existing = list.get(foundIndex);
        existing.setFullName(updateStudent.getFullName());
        return existing;
    }
}
