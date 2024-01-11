package org.ejercicio.pruebarelaciones.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // mappedBy hace referencia al nombre del atributo en Student.class
    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;
}
