-- 1) Listar los datos de los autores
SELECT * FROM autores;

-- 2) Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM estudiantes;

-- 3) ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiantes WHERE carrera = "Informatica";

-- 4) ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autores WHERE nacionalidad IN ("Francesa", "Italiana");

-- 5) ¿Qué libros no son del área de internet?
SELECT * FROM libros WHERE area != "Internet";

-- 6) Listar los libros de la editorial Salamandra
SELECT * FROM libros WHERE editorial = "Salamandra";

-- 7) Listar los datos de los estudiantes cuya edad es mayor al promedio
SELECT * FROM estudiantes WHERE edad > (SELECT AVG(edad) FROM estudiantes);

-- 8) Listar los nombres de los estudiantes cuyo apellido comience con la letra G
SELECT nombre FROM estudiantes WHERE apellido LIKE "G%";

-- 9) Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres)
SELECT a.nombre
FROM autores a, libros_autores la, libros l
WHERE a.id_autor = la.id_autor AND
	  la.id_libro = l.id_libro AND
      l.titulo = "El Universo: Guía de viaje";

-- 10) ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.titulo
FROM prestamos p, libros l, estudiantes e
WHERE e.id_lector = p.id_lector AND
	  p.id_libro = l.id_libro AND
      e.nombre = "Filippo" AND
      e.apellido = "Galli";

-- 11) Listar el nombre del estudiante de menor edad
SELECT nombre
FROM estudiantes
WHERE edad = (SELECT MIN(edad) FROM estudiantes);

-- 12) Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos
SELECT e.nombre
FROM estudiantes e, prestamos p, libros l
WHERE e.id_lector = p.id_lector AND
	  p.id_libro = l.id_libro AND
      l.area = "Base de Datos";

-- 13) Listar los libros que pertenecen a la autora J.K. Rowling
SELECT l.*
FROM libros l, libros_autores la, autores a
WHERE l.id_libro = la.id_libro AND
	  la.id_autor = a.id_autor AND
      a.nombre = "J.K. Rowling";

-- 14) Listar títulos de los libros que debían devolverse el 16/07/2021
SELECT l.titulo
FROM libros l, prestamos p
WHERE l.id_libro = p.id_libro AND
	  p.fecha_devolucion = '2021-07-16' AND
      p.devuelto = false;