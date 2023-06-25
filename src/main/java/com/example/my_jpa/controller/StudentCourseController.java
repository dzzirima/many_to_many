package com.example.my_jpa.controller;


import com.example.my_jpa.model.Course;
import com.example.my_jpa.model.Student;
import com.example.my_jpa.repository.CourseRepository;
import com.example.my_jpa.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    private StudentRepository studentRepository;
    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }


    @PostMapping
    public Student saveStudentWithCourse(
           @RequestBody Student student
    ){
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student>  findAllStudents(){
        return  studentRepository.findAll();
    }

    @GetMapping("/{studentId}")
    public Student findStudentById(
           @PathVariable Long studentId
    ){
        return  studentRepository.findById(studentId).orElse(null);
    }


    @GetMapping("/find/{name}")
    public List<Student> findStudentContainingByName(
            @PathVariable String name){

        return  studentRepository.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course>  findCourseLessThanPrice(
            @PathVariable double price
    ){
        return  courseRepository.findByFeeLessThan(price);
    }



}
