package com.example.relacionesJPA.entities;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "courses_like", // nombre de tabla intermedia
            joinColumns = @JoinColumn(name = "student_id"), //campo de tabla intermedia
            inverseJoinColumns = @JoinColumn(name = "course_id") //campo de tabla intermedia
    )
    private Set<Course> likedCourses;
}
