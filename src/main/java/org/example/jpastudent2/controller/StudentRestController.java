package org.example.jpastudent2.controller;

import org.example.jpastudent2.model.Student;
import org.example.jpastudent2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

//    @GetMapping("/student/{name}")
//    public Student getStudentByName(@PathVariable String name) {
//        return studentRepository.findByName(name);
//    }

    @GetMapping("/student/{name}")
    public ResponseEntity<Student> getStudentByName(@PathVariable String name) {
        Optional<Student> studentName = studentRepository.findByName(name);
        if (studentName.isPresent()) {
            return new ResponseEntity<>(studentName.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
           studentRepository.deleteById(id);
           return ResponseEntity.ok("Studnet deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }


    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student); //opda
    }

//    @PutMapping("/student/{id}")
//    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
//        Optional<Student> orgStudent = studentRepository.findById(student.getId());
//        if (orgStudent.isPresent()) {
//            studentRepository.save(student);
//            return ResponseEntity.ok(student);
//           // return new ResponseEntity<>(student, HttpStatus.OK);
//        } else {
//            return ResponseEntity.notFound().build();
//           // return new ResponseEntity<>(student, HttpStatus.NOT_FOUND);
//        }
//    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        Optional<Student> orgStudent =studentRepository.findById(student.getId());
        if (orgStudent.isPresent()) {
          studentRepository.save(student);
          return new ResponseEntity<>(student, HttpStatus.OK); //body er JSON
        } else {
           return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("students/{name}") public List<Student> getallstudentsbyname(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }
}
