package org.ejercicio.pruebarelaciones.model;

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
    // configuracion de la tabla intermedia
    // nombre de la tabla
    // Luego, de que manera quiero que se unan los ids que voy a tener
    @JoinTable(
            name = "couse_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> likedCourses;
}
