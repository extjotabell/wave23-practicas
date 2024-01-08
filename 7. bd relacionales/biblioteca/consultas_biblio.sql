-- Listar los datos de los autores.
SELECT * 
FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT CONCAT(nombre,' ',apellido) AS nombre, edad
FROM estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT CONCAT(nombre,' ',apellido) AS nombre, edad, carrera
FROM estudiante
WHERE carrera like "Computer Science";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * 
FROM Autor
WHERE nacionalidad = 'colombian' OR nacionalidad = 'british';

-- Listar los libros de la editorial Salamandra.
SELECT *
FROM libro
WHERE editorial = 'Vintage Books';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM estudiante
WHERE (SELECT avg(edad)
		FROM estudiante) < edad;

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT *
FROM estudiante
WHERE nombre like 'E%';

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT CONCAT(nombre,' ',apellido) as Nombre, titulo as prestamo
FROM Préstamo INNER JOIN
estudiante 
ON Préstamo.idLector = estudiante.idLector
INNER JOIN Libro
ON Préstamo.idLibro = libro.idLibro;

-- Listar el nombre del estudiante de menor edad.
SELECT *
FROM estudiante
ORDER BY edad ASC
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT *
FROM Préstamo INNER JOIN
Libro
ON Préstamo.idLibro = Libro.idLibro
INNER JOIN Estudiante
ON Préstamo.idLector = Estudiante.idLector
WHERE titulo = 'Pride and Prejudice';

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * 
FROM LibroAutor INNER JOIN
LIBRO
ON LibroAutor.idLibro = Libro.idLibro
INNER JOIN Autor
ON LibroAutor.idAutor = Autor.idAutor
WHERE nombre = 'J.K. Rowling';

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT *
FROM Préstamo INNER JOIN
Libro
ON Préstamo.idLibro = Libro.idLibro
WHERE fechaDevolucion <= "2023-03-15";