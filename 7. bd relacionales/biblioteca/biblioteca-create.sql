CREATE DATABASE IF NOT EXISTS Biblioteca;
USE Biblioteca;
CREATE TABLE Autor
(
  idAutor INT,
  Nombre VARCHAR(50),
  Nacionalidad VARCHAR(50),
  CONSTRAINT PK_Autor PRIMARY KEY (idAutor)
);

CREATE TABLE Libro
(
  idLibro INT,
  Titulo VARCHAR(100),
  Editorial VARCHAR(50),
  Area VARCHAR(50),
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
  Direccion VARCHAR(100) ,
  Carrera VARCHAR(50) ,
  Edad INT ,
  CONSTRAINT PK_Lector PRIMARY KEY (idLector)
);

CREATE TABLE Prestamo
(
  idLector INT,
  idLibro INT,
  FechaPrestamo DATE,
  FechaDevolucion DATE,
  Devuelto BIT,
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
(6, 'Mark A. Garlick', NULL),
(7, 'Oliver Berry', 'English'),
(8, 'Valerie Stimac', NULL),
(9, 'Mark Mackenzie', NULL),
(10, 'Simone de Beauvoir', 'French'),
(11, 'Carlo Collodi', 'Italian');


-- Insert data into Libro table
INSERT INTO Libro (idLibro, Titulo, Editorial, Area) VALUES 
(1, 'One Hundred Years of Solitude', 'Vintage Books', 'Magical Realism'),
(2, 'Pride and Prejudice', 'Penguin Classics', 'Classic Fiction'),
(3, 'Norwegian Wood', 'Vintage Books', 'Contemporary Fiction'),
(4, 'Harry Potter and the Sorcerer''s Stone', 'Scholastic', 'Fantasy'),
(5, 'Things Fall Apart', 'Anchor Books', 'African Literature'),
(6, 'El universo: Guía de viaje', 'GeoPlaneta', 'Science'),
(7, 'Harry Potter y la Orden del Fénix', 'Salamandra', 'Fantasy'),
(8, 'Fundamentos de sistemas de bases de datos', 'Pearson', 'Databases');

-- Insert data into LibroAutor table
INSERT INTO LibroAutor (idAutor, idLibro) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 6),
(8, 6),
(9, 6),
(4, 7);

-- Insert data into Estudiante table
INSERT INTO Estudiante (idLector, Nombre, Apellido, Direccion, Carrera, Edad) VALUES
(1, 'John', 'Doe', '123 Main St', 'Computer Science', 20),
(2, 'Alice', 'Smith', '456 Oak St', 'Literature', 22),
(3, 'Bob', 'Johnson', '789 Pine St', 'Physics', 21),
(4, 'Emma', 'Williams', '101 Elm St', 'Medicine', 17),
(5, 'David', 'Brown', '202 Maple St', 'History', 22),
(6, 'Filippo', 'Galli', '205 Maple St', 'History', 22);

-- Insert data into Prestamo table
INSERT INTO Prestamo (idLector, idLibro, FechaPrestamo, FechaDevolucion, Devuelto) VALUES
(1, 1, '2023-01-01', '2023-01-15', 1),
(2, 2, '2023-02-01', '2023-02-15', 1),
(3, 3, '2023-03-01', '2023-03-15', 0),
(4, 4, '2021-07-02', '2021-07-16', 0),
(5, 5, '2023-05-01', NULL, 0),
(6, 7, '2023-05-01', 2023-05-15, 0);