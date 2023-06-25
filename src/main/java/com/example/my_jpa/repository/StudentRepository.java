package com.example.my_jpa.repository;

import com.example.my_jpa.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student ,Long> {
   List<Student> findByNameContaining(String name);
}
