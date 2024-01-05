-- Listar los datos de los autores.
SELECT * FROM autores;
-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiantes;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiantes WHERE carrera LIKE "Informática";
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autores WHERE nacionalidad IN ('Francesa', 'Italiana');
-- ¿Qué libros no son del área de internet?
SELECT * FROM libros WHERE area NOT LIKE "Internet";
-- Listar los libros de la editorial Salamandra.
SELECT * FROM libros WHERE editorial LIKE "Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM estudiantes WHERE edad > (SELECT AVG(edad) FROM estudiantes);
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT nombre, apellido FROM estudiantes WHERE apellido LIKE 'G%';
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
-- Con subconsulta
select a.nombre 
from autores a natural join libros_autores la
where la.id_libro = (select id_libro from libros where titulo like "El Universo: Guía de viaje");
-- Con JOIN
SELECT autores.nombre FROM
	autores NATURAL JOIN libros_autores
    NATURAL JOIN libros
    WHERE libros.titulo = 'El Universo: Guía de viaje';
    
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
-- Con Subconsulta
select * from libros
where id_libro = (select id_libro 
					from prestamos 
					where id_lector = (
						select id_lector 
						from estudiantes 
						where nombre 
						like "Filippo" and apellido like "Galli"));

-- Con JOIN
SELECT libros.* FROM
	libros NATURAL JOIN prestamos
    NATURAL JOIN estudiantes
    WHERE estudiantes.nombre = 'Filippo' AND estudiantes.apellido = 'Galli';
    
-- Listar el nombre del estudiante de menor edad.
SELECT estudiantes.nombre FROM estudiantes
	WHERE edad = (SELECT MIN(edad) FROM estudiantes);
    
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT estudiantes.nombre, estudiantes.apellido FROM
	libros NATURAL JOIN prestamos
    NATURAL JOIN estudiantes
    where libros.area like "Base de Datos";
    
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT libros.* FROM
	autores NATURAL JOIN libros_autores
    NATURAL JOIN libros
    WHERE autores.nombre = 'J.K. Rowling';
    
-- Listar títulos de los libros que debían devolverse el 16/07/2021.

select l.titulo from libros l
natural join prestamos p
where p.fecha_devolucion = '2021-07-16';
