package com.example.my_jpa.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Course {

    @SequenceGenerator(
            name = "course_sequence",
            allocationSize = 1,
            sequenceName = "course_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    @Id
    private Long id;
    private  String title;
    private  String abbreviation;
    private  int modules;
    private  double fee;

    // relationships
    // mapped by means who is the owner of this relationship
    @ManyToMany(
            mappedBy = "courses" ,
            cascade = CascadeType.ALL ,
            fetch = FetchType.LAZY
    )
    @JsonBackReference
    private Set<Student> students;

}
