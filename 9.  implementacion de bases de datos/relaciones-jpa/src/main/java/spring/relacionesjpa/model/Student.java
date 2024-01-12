package spring.relacionesjpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "courses_like",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> likedCourses;
}
