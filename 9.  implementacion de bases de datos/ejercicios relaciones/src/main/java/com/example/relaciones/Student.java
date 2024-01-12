package com.example.relaciones;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable (name = "course_like", joinColumns = @JoinColumn (name = "student_id"), inverseJoinColumns = @JoinColumn (name = "course_id"))
    private Set<Course> likedCourses;
}
