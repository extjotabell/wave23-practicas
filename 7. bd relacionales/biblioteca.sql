DROP TABLE IF EXISTS Biblioteca;
CREATE DATABASE IF NOT EXISTS Biblioteca;
USE Biblioteca;

CREATE TABLE Autor
(
  idAutor INT ,
  Nombre VARCHAR(50),
  Nacionalidad VARCHAR(50) ,
  CONSTRAINT PK_Autor PRIMARY KEY (idAutor)
);

CREATE TABLE Libro
(
  idLibro INT,
  Título VARCHAR(100) ,
  Editorial VARCHAR(50) ,
  Área VARCHAR(50) ,
  CONSTRAINT PK_Libro PRIMARY KEY (idLibro)
);

CREATE TABLE LibroAutor
(
  idAutor INT,
  idLibro INT,
  CONSTRAINT PK_LibroAutor PRIMARY KEY (idAutor, idLibro),
  CONSTRAINT FK_LibroAutor_Autor FOREIGN KEY (idAutor) REFERENCES Autor (idAutor),
  CONSTRAINT FK_LibroAutor_Libro FOREIGN KEY (idLibro) REFERENCES Libro (idLibro)
);

CREATE TABLE Estudiante
(
  idLector INT,
  Nombre VARCHAR(50) ,
  Apellido VARCHAR(50) ,
  Dirección VARCHAR(100) ,
  Carrera VARCHAR(50) ,
  Edad INT ,
  CONSTRAINT PK_Lector PRIMARY KEY (idLector)
);

CREATE TABLE Préstamo
(
  idLector INT,
  idLibro INT,
  FechaPrestamo DATE ,
  FechaDevolucion DATE,
  Devuelto BIT ,
  CONSTRAINT PK_Prestamo PRIMARY KEY (idLector, idLibro),
  CONSTRAINT FK_Prestamo_Lector FOREIGN KEY (idLector) REFERENCES Estudiante (idLector),
  CONSTRAINT FK_Prestamo_Libro FOREIGN KEY (idLibro) REFERENCES Libro (idLibro)
);

-- Insert data into Autor table
INSERT INTO Autor (idAutor, Nombre, Nacionalidad) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombian'),
(2, 'Jane Austen', 'English'),
(3, 'Haruki Murakami', 'Japanese'),
(4, 'J.K. Rowling', 'British'),
(5, 'Chinua Achebe', 'Nigerian'),
(6, 'Albert Camus', 'French'),
(7, 'Italo Calvino', 'Italian');

-- Insert data into Libro table
INSERT INTO Libro (idLibro, Título, Editorial, Área) VALUES
(1, 'One Hundred Years of Solitude', 'Vintage Books', 'Magical Realism'),
(2, 'Pride and Prejudice', 'Penguin Classics', 'Classic Fiction'),
(3, 'Norwegian Wood', 'Vintage Books', 'Contemporary Fiction'),
(4, 'Harry Potter and the Sorcerer''s Stone', 'Scholastic', 'Fantasy'),
(5, 'Things Fall Apart', 'Anchor Books', 'African Literature'),
(6, 'The Stranger', 'Vintage Books', 'Existentialism'),
(7, 'Invisible Cities', 'Harcourt Brace Jovanovich', 'Postmodern Fiction');

-- Insert data into LibroAutor table
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7);

-- Insert data into Estudiante table
INSERT INTO Estudiante (idLector, Nombre, Apellido, Dirección, Carrera, Edad) VALUES
(1, 'John', 'Doe', '123 Main St', 'Computer Science', 20),
(2, 'Alice', 'Smith', '456 Oak St', 'Literature', 22),
(3, 'Bob', 'Johnson', '789 Pine St', 'Physics', 21),
(4, 'Emma', 'Williams', '101 Elm St', 'Medicine', 23),
(5, 'David', 'Brown', '202 Maple St', 'History', 22),
(6, 'Sophia', 'Lee', '303 Cedar St', 'Computer Science', 20),
(7, 'Michael', 'Taylor', '404 Walnut St', 'Computer Science', 21);

-- Insert data into Préstamo table
INSERT INTO Préstamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-01', '2023-01-15', 1),
(2, 2, '2023-02-01', '2023-02-15', 1),
(3, 3, '2023-03-01', '2023-03-15', 0),
(4, 4, '2023-04-01', NULL, 0),
(5, 5, '2023-05-01', NULL, 0),
(6, 1, '2023-06-01', NULL, 0),
(7, 7, '2023-07-01', NULL, 0);

-- Listar los datos de los autores.
SELECT * 
FROM Autor;

-- Listar nombre y edad de los estudiantes
EXPLAIN SELECT e.Nombre, e.Edad
FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * 
FROM Estudiante e
WHERE e.Carrera = "Computer Science";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * 
FROM Autor a
WHERE a.Nacionalidad = "French" OR a.Nacionalidad = "Italian";

-- ¿Qué libros no son del área de internet?
SELECT * 
FROM Libro l
WHERE l.Área != "Internet";

-- Listar los libros de la editorial Salamandra.
SELECT * 
FROM Libro l
WHERE l.Editorial = "Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * 
FROM Estudiante e
WHERE e.Edad > (
	SELECT AVG(e2.Edad)
    FROM Estudiante e2
);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT e.Nombre
FROM Estudiante e
WHERE e.Apellido LIKE "G%";

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT a.Nombre
FROM Autor a
JOIN LibroAutor la ON la.idAutor = a.idAutor
JOIN Libro l ON l.idLibro = la.idLibro
WHERE l.Título LIKE "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT l.idLibro, l.Título, l.Editorial, l.Área
FROM Libro l 
JOIN Préstamo p ON l.idLibro = p.idLibro
JOIN Estudiante e ON p.idLector = e.idLector
WHERE e.Nombre LIKE "Filippo" AND e.Apellido LIKE "Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT e.Nombre
FROM Estudiante e
WHERE e.Edad < 18;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT e.Nombre
FROM Estudiante e
JOIN Préstamo p ON e.idLector = p.IdLector
JOIN Libro l ON l.idLibro = p.idLibro
WHERE l.Área LIKE "Base de Datos"; 

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT l.* 
FROM Libro l
JOIN LibroAutor la ON la.idLibro = l.idLibro
JOIN Autor a ON a.idAutor = la.idAutor
WHERE a.Nombre LIKE "J.K. Rowling";

/*
SIN JOIN 
SELECT *
FROM Libro
WHERE idLibro IN (
    SELECT idLibro
    FROM LibroAutor
    WHERE idAutor = (
        SELECT idAutor
        FROM Autor
        WHERE Nombre = 'J.K. Rowling'
    )
);
 */

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT Libro.Título
FROM Libro 
WHERE Libro.idLibro = (
    SELECT Préstamo.idLibro
    FROM Préstamo
    WHERE Préstamo.FechaDevolucion = '2021-07-16'
);

/* 
CON JOINS
SELECT Libro.Título
FROM Libro
JOIN Préstamo ON Préstamo.idLibro = Libro.idLibro
WHERE Préstamo.FechaDevolucion = '2021-07-16' 
*/ 

