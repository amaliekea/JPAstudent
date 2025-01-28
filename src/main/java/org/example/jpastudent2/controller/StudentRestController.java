package org.example.jpastudent2.controller;

import org.example.jpastudent2.model.Student;
import org.example.jpastudent2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

//    @GetMapping("/addstudent")
//    public List<Student> addstudent() {
//        Student std = new Student();
//        std.setBornDate(LocalDate.now());
//        return studentRepository.findAll();
//    }
    @GetMapping("students/{name}") public List<Student> getallstudentsbyname(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }
}
