package spring.relacionesjpa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "likedCourses")
    private Set<Student> likes;

}
