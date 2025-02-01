package org.example.jpastudent2.repositories;

import org.example.jpastudent2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);

    Optional<Student> findByName(String name);
}
