package org.example.jpastudent2.repositories;

import org.example.jpastudent2.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void findAll() {
        List<Student> students = studentRepository.findAll();
        assertEquals(2, students.size());
    }
    @Test
    void findOne() {
        List<Student> one = studentRepository.findAllByName("amalie");
        assertEquals(1, one.size());
    }
    @Test
    void ChangeOne() {
        Student s1 = new Student();
        s1.setName("viggo");
        s1.setBornDate(LocalDate.of(2010,10,11));
        studentRepository.save(s1);
        List<Student> one = studentRepository.findAllByName("viggo");
        assertEquals(1, one.size());
    }
}