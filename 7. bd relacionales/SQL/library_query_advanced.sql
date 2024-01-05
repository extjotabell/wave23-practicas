DROP DATABASE IF EXISTS Biblioteca;
CREATE DATABASE IF NOT EXISTS bibioteca;

USE bibioteca;

CREATE TABLE autor
(
  id INT ,
  nombre VARCHAR(50),
  nacionalidad VARCHAR(50) ,
  CONSTRAINT PK_Autor PRIMARY KEY (id)
);

CREATE TABLE libro
(
  id INT,
  titulo VARCHAR(100) ,
  editorial VARCHAR(50) ,
  area VARCHAR(50) ,
  CONSTRAINT PK_Libro PRIMARY KEY (id)
);

CREATE TABLE libro_autor
(
  id_autor INT,
  id_libro INT,
  CONSTRAINT PK_LibroAutor PRIMARY KEY (id_autor, id_libro),
  CONSTRAINT FK_LibroAutor_Autor FOREIGN KEY (id_autor) REFERENCES Autor (id),
  CONSTRAINT FK_LibroAutor_Libro FOREIGN KEY (id_libro) REFERENCES Libro (id)
);

CREATE TABLE estudiante
(
  id INT,
  nombre VARCHAR(50) ,
  apellido VARCHAR(50) ,
  direccion VARCHAR(100) ,
  carrera VARCHAR(50) ,
  edad INT ,
  CONSTRAINT PK_Lector PRIMARY KEY (id)
);

CREATE TABLE prestamo
(
  id_estudiante INT,
  id_libro INT,
  fecha_prestamo DATE ,
  fecha_devolucion DATE,
  devuelto BIT ,
  CONSTRAINT PK_Prestamo PRIMARY KEY (id_estudiante, id_libro),
  CONSTRAINT FK_Prestamo_Lector FOREIGN KEY (id_estudiante) REFERENCES Estudiante (id),
  CONSTRAINT FK_Prestamo_Libro FOREIGN KEY (id_libro) REFERENCES Libro (id)
);

-- Insert data into Autor table
INSERT INTO Autor (id, nombre, nacionalidad) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombiano'),
(2, 'Jane Austen', 'Británico'),
(3, 'Haruki Murakami', 'Japonés'),
(4, 'J.K. Rowling', 'Británico'),
(5, 'Chinua Achebe', 'Nigeriano'),
(6, 'Albert Camus', 'Francés'),
(7, 'Italo Calvino', 'Italiano'),
(8, 'Autores de Internet 1', 'Desconocido'),
(9, 'Autor de El Universo', 'Desconocido');

-- Insert data into Libro table
INSERT INTO Libro (id, titulo, editorial, area) VALUES
(1, 'One Hundred Years of Solitude', 'Vintage Books', 'Magical Realism'),
(2, 'Pride and Prejudice', 'Salamandra', 'Classic Fiction'),
(3, 'Norwegian Wood', 'Vintage Books', 'Contemporary Fiction'),
(4, 'Harry Potter and the Sorcerer''s Stone', 'Scholastic', 'Fantasy'),
(5, 'Things Fall Apart', 'Salamandra', 'African Literature'),
(6, 'The Pragmatic Programmer', 'Addison-Wesley', 'Internet'),
(7, 'Clean Code: A Handbook of Agile Software Craftsmanship', 'Prentice Hall', 'Internet'),
(8, 'The Art of Computer Programming', 'Addison-Wesley', 'Internet'),
(9, 'El Universo: Guía de viaje', 'Galactic Press', 'Astronomy');

-- Insert data into LibroAutor table
INSERT INTO libro_autor (id_autor, id_libro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(8, 6),
(9, 9);

-- Insert data into Estudiante table
INSERT INTO estudiante (id, nombre, apellido, direccion, carrera, edad) VALUES
(1, 'John', 'Doe', '123 Main St', 'Computer Science', 20),
(2, 'Alice', 'Smith', '456 Oak St', 'Literature', 22),
(3, 'Bob', 'Johnson', '789 Pine St', 'Physics', 21),
(4, 'Emma', 'Williams', '101 Elm St', 'Medicine', 23),
(5, 'David', 'Brown', '202 Maple St', 'History', 22),
(6, 'Marcelo', 'Gomez', '202 Maple St', 'Computer Science', 22);

-- Insert data into Préstamo table
INSERT INTO prestamo (id_estudiante, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1, 1, '2023-01-01', '2023-01-15', 1),
(2, 2, '2023-02-01', '2023-02-15', 1),
(3, 3, '2023-03-01', '2023-03-15', 0),
(4, 4, '2023-04-01', NULL, 0),
(5, 5, '2023-05-01', NULL, 0);



-- Listar los datos de los autores.
SELECT 
	*
FROM 
	autor;

-- Listar nombre y edad de los estudiantes
SELECT 
	nombre, edad
FROM 
	estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT 
	nombre
FROM 
	estudiante
WHERE
	carrera LIKE '%informática%';

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT 
	nombre,
    nacionalidad
FROM 
	autor
WHERE
	nacionalidad LIKE '%francés%' OR nacionalidad LIKE '%italiano%';

-- ¿Qué libros no son del área de internet?
SELECT 
	titulo, area
FROM 
	libro
WHERE 
	area NOT LIKE '%internet%';

-- Listar los libros de la editorial Salamandra.
SELECT 
	titulo, area
FROM 
	libro
WHERE editorial = 'Salamandra';

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT
    *
FROM
    estudiante
WHERE
    edad > (SELECT AVG(edad) FROM estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT
	nombre
FROM 
	estudiante
WHERE
	apellido LIKE '%G';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).


-- ¿Qué libros se prestaron al lector “Filippo Galli”?
-- Listar el nombre del estudiante de menor edad.
-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
-- Listar los libros que pertenecen a la autora J.K. Rowling.
-- Listar títulos de los libros que debían devolverse el 16/07/2021.

