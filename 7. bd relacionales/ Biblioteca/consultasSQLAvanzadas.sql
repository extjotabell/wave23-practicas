-- Listar los datos de los autores.
SELECT * FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT nombre, edad FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM Estudiante WHERE Carrera = 'Computer Science';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor WHERE Nacionalidad = 'French' OR Nacionalidad = 'Italian';

-- ¿Qué libros no son del área de internet?
SELECT * FROM Libro WHERE Área != 'Internet';

-- Listar los libros de la editorial Salamandra.
SELECT * FROM Libro WHERE Editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante
WHERE EDAD > (SELECT avg(Edad) FROM Estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM Estudiante WHERE Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.Nombre FROM Autor a
JOIN LibroAutor la ON la.idAutor = a.idAutor
JOIN Libro l ON l.idLibro = la.idLibro
WHERE l.Título = 'El Universo: Guía de viaje';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.* FROM Libro l
JOIN Préstamo p ON p.idLibro = l.idLibro
JOIN Estudiante e ON p.idLector = e.idLector
WHERE e.Nombre = 'Filippo' AND e.Apellido = 'Galli';

-- Listar el nombre del estudiante de menor edad.
SELECT e.Nombre FROM Estudiante e
WHERE e.Edad = (SELECT MIN(e2.Edad) FROM Estudiante e2);

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre FROM Estudiante e
JOIN Préstamo p ON p.idLector = e.idLector
JOIN Libro l ON l.idLibro = p.idLibro
WHERE l.Área = 'Base de Datos';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* FROM Libro l
JOIN LibroAutor la ON la.idLibro = l.idLibro
JOIN Autor a ON a.idAutor = la.idAutor
WHERE a.Nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT l.Título FROM Libro l
JOIN Préstamo p ON p.idLibro = l.idLibro
WHERE p.FechaDevolucion = '2021-07-16';
