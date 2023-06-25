package com.example.my_jpa.repository;

import com.example.my_jpa.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course , Long> {
    List<Course> findByFeeLessThan(double price);
}
