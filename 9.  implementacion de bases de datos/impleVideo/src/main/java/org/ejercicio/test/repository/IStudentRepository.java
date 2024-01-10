package org.ejercicio.test.repository;

import org.ejercicio.test.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// JpaRepository<Clase que vamos a mapear respecto a la DB, Tipo de datod e ID del objeto>
public interface IStudentRepository extends JpaRepository<Student, Long> {
}
