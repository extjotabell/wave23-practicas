CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

CREATE TABLE autor
(
  idAutor INT ,
  nombre VARCHAR(50),
  nacionalidad VARCHAR(50) ,
  CONSTRAINT PK_Autor PRIMARY KEY (idAutor)
);

CREATE TABLE libro
(
  idLibro INT,
  titulo VARCHAR(100) ,
  editorial VARCHAR(50) ,
  area VARCHAR(50) ,
  CONSTRAINT PK_Libro PRIMARY KEY (idLibro)
);

CREATE TABLE libroAutor
(
  idAutor INT,
  idLibro INT,
  CONSTRAINT PK_LibroAutor PRIMARY KEY (idAutor, idLibro),
  CONSTRAINT FK_LibroAutor_Autor FOREIGN KEY (idAutor) REFERENCES autor (idAutor),
  CONSTRAINT FK_LibroAutor_Libro FOREIGN KEY (idLibro) REFERENCES libro (idLibro)
);

CREATE TABLE estudiante
(
  idLector INT,
  nombre VARCHAR(50) ,
  apellido VARCHAR(50) ,
  direccion VARCHAR(100) ,
  carrera VARCHAR(50) ,
  edad INT ,
  CONSTRAINT PK_Lector PRIMARY KEY (idLector)
);

CREATE TABLE prestamo
(
  idLector INT,
  idLibro INT,
  fechaPrestamo DATE ,
  fechaDevolucion DATE,
  devuelto BIT ,
  CONSTRAINT PK_Prestamo PRIMARY KEY (idLector, idLibro),
  CONSTRAINT FK_Prestamo_Lector FOREIGN KEY (idLector) REFERENCES estudiante (idLector),
  CONSTRAINT FK_Prestamo_Libro FOREIGN KEY (idLibro) REFERENCES libro (idLibro)
);

-- Insert data into Autor table
INSERT INTO autor (idAutor, nombre, nacionalidad) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombian'),
(2, 'Jane Austen', 'English'),
(3, 'Haruki Murakami', 'Japanese'),
(4, 'J.K. Rowling', 'British'),
(5, 'Chinua Achebe', 'Nigerian'),
(6, 'Giovanni Boccaccio', 'Italian');

-- Insert data into Libro table
INSERT INTO libro (idLibro, titulo, editorial, area) VALUES
(1, 'One Hundred Years of Solitude', 'Vintage Books', 'Magical Realism'),
(2, 'Pride and Prejudice', 'Penguin Classics', 'Classic Fiction'),
(3, 'Norwegian Wood', 'Vintage Books', 'Contemporary Fiction'),
(4, 'Harry Potter and the Sorcerer''s Stone', 'Scholastic', 'Fantasy'),
(5, 'Things Fall Apart', 'Anchor Books', 'African Literature'),
(6, 'Learning TI', 'CV', 'TI');

-- Insert data into LibroAutor table
INSERT INTO libroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insert data into Estudiante table
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'John', 'Doe', '123 Main St', 'Computer Science', 20),
(2, 'Alice', 'Smith', '456 Oak St', 'Literature', 22),
(3, 'Bob', 'Johnson', '789 Pine St', 'Physics', 21),
(4, 'Emma', 'Williams', '101 Elm St', 'Medicine', 23),
(5, 'David', 'Brown', '202 Maple St', 'History', 22);

-- Insert data into Préstamo table
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto) VALUES
(1, 1, '2023-01-01', '2023-01-15', 1),
(2, 2, '2023-02-01', '2023-02-15', 1),
(3, 3, '2023-03-01', '2023-03-15', 0),
(4, 4, '2023-04-01', NULL, 0),
(5, 5, '2023-05-01', NULL, 0);

-- Consultas

-- 1 - Listar los datos de los autores.
SELECT nombre,nacionalidad FROM autor;

-- 2 - Listar nombre y edad de los estudiantes.
SELECT nombre, edad FROM estudiante;

-- 3 - ¿Qué estudiantes pertenecen a la carrera informática?
SELECT nombre,apellido,carrera FROM estudiante
WHERE carrera LIKE 'Computer%';

-- 4 - ¿Qué autores son de nacionalidad francesa o italiana?
SELECT nombre,nacionalidad FROM autor
WHERE nacionalidad LIKE 'Italian';

-- 5 - ¿Qué libros no son del área de internet?
SELECT titulo, area FROM libro
WHERE area LIKE 'TI';

-- 6 - Listar los libros de la editorial Salamandra / Penguin .
SELECT titulo FROM libro
WHERE editorial LIKE 'Salamandra';

SELECT titulo FROM libro
WHERE editorial LIKE 'Penguin%';

-- 7 - Listar los datos de los estudiantes cuya edad es mayor al promedio.
SET @edadPromedio = (
	SELECT AVG(edad) FROM estudiante
);
SELECT nombre,edad FROM estudiante
WHERE edad > @edadPromedio;

-- 8 - Listar los nombres de los estudiantes cuyo apellido comience con la letra G / J.
SELECT nombre FROM estudiante
WHERE apellido LIKE 'G%';

SELECT nombre FROM estudiante
WHERE apellido LIKE 'J%';

-- 9 - Listar los autores del libro "El Universo: Guía de viaje" / "Norwegian Wood" (Se debe listar solamente los nombres).
SELECT autor.nombre FROM autor
INNER JOIN libroAutor ON libroAutor.idAutor = autor.idAutor
INNER JOIN libro ON libroAutor.idLibro = libro.idLibro     
WHERE libro.titulo like 'El Universo: Guía de viaje';

SELECT autor.nombre FROM autor
INNER JOIN libroAutor ON libroAutor.idAutor = autor.idAutor
INNER JOIN libro ON libroAutor.idLibro = libro.idLibro     
WHERE libro.titulo like 'Norwegian Wood';

-- 10 - ¿Qué libros se prestaron al lector "Filippo Galli"/ "Alice Smith"?
SELECT libro.titulo FROM estudiante
INNER JOIN prestamo ON estudiante.idLector = prestamo.idLector
INNER JOIN libro ON libro.idLibro = prestamo.idLibro
WHERE nombre LIKE 'Filippo' AND  apellido LIKE 'Galli';

SELECT libro.titulo FROM estudiante
INNER JOIN prestamo ON estudiante.idLector = prestamo.idLector
INNER JOIN libro ON libro.idLibro = prestamo.idLibro
WHERE nombre LIKE 'Alice' AND  apellido LIKE 'Smith';

-- 11 - Listar el nombre del estudiante de menor edad.
SELECT nombre FROM estudiante ORDER BY edad LIMIT 1;

-- 12 - Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos / Fantasy.
SELECT  nombre,apellido FROM estudiante
INNER JOIN prestamo ON prestamo.idLector = estudiante.idLector
INNER JOIN libro ON libro.idLibro = prestamo.idLibro
WHERE libro.area LIKE 'Base de Datos';

SELECT  nombre,apellido FROM estudiante
INNER JOIN prestamo ON prestamo.idLector = estudiante.idLector
INNER JOIN libro ON libro.idLibro = prestamo.idLibro
WHERE libro.area LIKE 'Fantasy';

-- 13 - Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT * FROM libro
INNER JOIN libroAutor  ON libro.idLibro = libroAutor.idLibro
INNER JOIN autor ON libroAutor.idAutor = autor.idAutor
WHERE autor.nombre = 'J.K. Rowling';

-- 14 -Listar títulos de los libros que debían devolverse el 2023-03-15.
SELECT libro.titulo FROM libro
JOIN prestamo ON libro.idLibro = prestamo.idLibro
WHERE prestamo.fechaDevolucion = '2023-03-15';
