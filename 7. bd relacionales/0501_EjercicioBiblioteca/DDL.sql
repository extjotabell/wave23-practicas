-- Script creado por Sebnastian Ospina Garcia

CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

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

CREATE TABLE Prestamo
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
(5, 'Chinua Achebe', 'Nigerian');

-- Insert data into Libro table
INSERT INTO Libro (idLibro, Título, Editorial, Área) VALUES
(1, 'One Hundred Years of Solitude', 'Vintage Books', 'Magical Realism'),
(2, 'Pride and Prejudice', 'Penguin Classics', 'Classic Fiction'),
(3, 'Norwegian Wood', 'Vintage Books', 'Contemporary Fiction'),
(4, 'Harry Potter and the Sorcerer''s Stone', 'Scholastic', 'Fantasy'),
(5, 'Things Fall Apart', 'Anchor Books', 'African Literature');

-- Insert data into LibroAutor table
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

-- Insert data into Estudiante table
INSERT INTO Estudiante (idLector, Nombre, Apellido, Dirección, Carrera, Edad) VALUES
(1, 'John', 'Doe', '123 Main St', 'Computer Science', 20),
(2, 'Alice', 'Smith', '456 Oak St', 'Literature', 22),
(3, 'Bob', 'Johnson', '789 Pine St', 'Physics', 21),
(4, 'Emma', 'Williams', '101 Elm St', 'Medicine', 23),
(5, 'David', 'Brown', '202 Maple St', 'History', 22);

-- Insert data into Préstamo table
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-01', '2023-01-15', 1),
(2, 2, '2023-02-01', '2023-02-15', 1),
(3, 3, '2023-03-01', '2023-03-15', 0),
(4, 4, '2023-04-01', NULL, 0),
(5, 5, '2023-05-01', NULL, 0);