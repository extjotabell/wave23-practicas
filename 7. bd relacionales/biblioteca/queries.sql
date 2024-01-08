/* Listar los datos de los autores. */
SELECT * FROM Autor;

/* Listar nombre y edad de los estudiantes */
SELECT Nombre, Edad FROM Estudiante;

/* ¿Qué estudiantes pertenecen a la carrera informática? */
SELECT Nombre, Apellido FROM Estudiante
WHERE Carrera = 'Computer Science';

/* ¿Qué autores son de nacionalidad francesa o italiana? */
SELECT Nombre FROM Autor
WHERE Nacionalidad IN ('French', 'Italian');

/* ¿Qué libros no son del área de internet? */
SELECT Titulo FROM Libro
WHERE Area NOT LIKE '%Internet%';

/* Listar los libros de la editorial Salamandra. */
SELECT Titulo FROM Libro
WHERE Editorial = 'Salamandra';

/* Listar los datos de los estudiantes cuya edad es mayor al promedio. */
SELECT * FROM Estudiante
WHERE edad > (SELECT AVG(edad) FROM Estudiante);

/* Listar los nombres de los estudiantes cuyo apellido comience con la letra G. */
SELECT Nombre FROM Estudiante
WHERE Apellido LIKE 'G%';

/* Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres). */
SELECT Autor.Nombre FROM Autor
INNER JOIN LibroAutor ON Autor.idAutor = LibroAutor.idAutor
INNER JOIN Libro ON Libro.idLibro = LibroAutor.idLibro
WHERE Libro.Titulo = 'El Universo: Guía de viaje';

/* ¿Qué libros se prestaron al lector “Filippo Galli”? */
SELECT Libro.Titulo FROM Prestamo
INNER JOIN Libro ON Libro.idLibro = Prestamo.idLibro
INNER JOIN Estudiante ON Estudiante.idLector = Prestamo.idLector
WHERE Prestamo.idLector = (SELECT idLector FROM Estudiante WHERE Nombre = 'Filippo' AND Apellido = 'Galli');

/* Listar el nombre del estudiante de menor edad. */
SELECT Estudiante.Nombre FROM Estudiante
WHERE Edad = (SELECT MIN(Edad) FROM Estudiante);

/* Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos. */
SELECT Estudiante.Nombre FROM Prestamo
INNER JOIN Estudiante ON Prestamo.idLector = Estudiante.idLector
INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
WHERE Libro.Area LIKE '%Databases%';

/* Listar los libros que pertenecen a la autora J.K. Rowling. */
SELECT Libro.Titulo FROM LibroAutor
INNER JOIN Libro ON LibroAutor.idLibro = Libro.idLibro
INNER JOIN Autor ON LibroAutor.idAutor = Autor.idAutor
WHERE Autor.Nombre = 'J.K. Rowling';

/* Listar títulos de los libros que debían devolverse el 16/07/2021. */
SELECT Libro.Titulo FROM Prestamo
INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
WHERE Prestamo.FechaDevolucion = '2021-07-16';