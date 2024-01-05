-- Listar los datos de los autores.
SELECT * FROM Autor;
-- Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad FROM estudiante e;
-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT e.nombre FROM estudiante e WHERE e.carrera LIKE "Informatica";
-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT a.nombre, a.nacionalidad FROM autor a WHERE a.nacionalidad = "Italiana" OR a.nacionalidad = "Francesa";
-- ¿Qué libros no son del área de internet?
SELECT * FROM Libro WHERE area NOT LIKE "Internet";
-- Listar los libros de la editorial Salamandra.
SELECT l.titulo, l.editorial FROM libro l WHERE l.editorial LIKE "Salamandra";
-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT estudiante.* FROM estudiante WHERE estudiante.edad > (SELECT AVG(estudiante.edad) FROM estudiante);  
-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.nombre FROM estudiante e WHERE UPPER(e.apellido) LIKE "G%";
-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.nombre FROM autor a,libro l,libro_autor la WHERE a.idAutor = la.idAutor AND l.idLibro = la.idLibro AND l.titulo LIKE "El Universo: Guía de viaje";
-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT * FROM libro JOIN prestamo ON libro.idLibro = prestamo.idLibro WHERE idLector IN (SELECT idLector FROM estudiante WHERE nombre LIKE "Filippo" AND apellido LIKE "Galli");
-- Listar el nombre del estudiante de menor edad.
SELECT e.nombre, e.edad FROM estudiante e ORDER BY e.edad DESC LIMIT 1;
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.nombre
FROM estudiante e
JOIN prestamo p ON e.idLector = p.idLector
JOIN libro l ON p.idLibro = l.idLibro
WHERE UPPER(l.area) LIKE 'BASE DE DATOS';
-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * 
FROM libro  
JOIN libro_autor ON libro.idLibro = libro_autor.idLibro
JOIN autor ON autor.idAutor = libro_autor.idAutor
WHERE autor.nombre LIKE "J.K. Rowling";
-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT titulo 
FROM libro l
JOIN prestamo p ON l.idLibro = p.idLibro WHERE p.fecha_devolucion = "2021-07-16";
