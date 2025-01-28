package org.example.jpastudent2.config;

import org.example.jpastudent2.model.Student;
import org.example.jpastudent2.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Bruce");
        s1.setBornDate(LocalDate.of(2011,11,12));
        s1.setBornTime(LocalTime.of(10,11,12));

        studentRepository.save(s1);
        studentRepository.save(s1);
        studentRepository.save(s1);

        Student s2 = new Student();
        s2.setName("amalie");
        s2.setBornDate(LocalDate.of(2022,11,12));
        s2.setBornTime(LocalTime.of(9,11,12));

        studentRepository.save(s2);
        studentRepository.save(s2);
        studentRepository.save(s2);
    }
}
