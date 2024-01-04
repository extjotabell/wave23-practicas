-- Creación de la tabla libro
CREATE TABLE libro (
  idLibro INT PRIMARY KEY,
  titulo VARCHAR(255) NOT NULL,
  editorial VARCHAR(255) NOT NULL,
  area VARCHAR(255) NOT NULL
);

-- Creación de la tabla autor
CREATE TABLE autor (
  idAutor INT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  nacionalidad VARCHAR(255) NOT NULL
);

-- Creación de la tabla estudiante
CREATE TABLE estudiante (
  idLector INT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL,
  apellido VARCHAR(255) NOT NULL,
  direccion VARCHAR(255) NOT NULL,
  carrera VARCHAR(255) NOT NULL,
  edad INT NOT NULL CHECK (edad > 0)
);

-- Creación de la tabla libroAutor
CREATE TABLE libroAutor (
  idAutor INT,
  idLibro INT,
  FOREIGN KEY (idLibro) REFERENCES libro(idLibro),
  FOREIGN KEY (idAutor) REFERENCES autor(idAutor),
  PRIMARY KEY (idAutor, idLibro)
);

-- Creación de la tabla prestamo
CREATE TABLE prestamo (
  idLector INT,
  idLibro INT,
  fechaPrestamo DATE NOT NULL,
  fechaDevolucion DATE NOT NULL,
  devuelto BOOLEAN NOT NULL,
  CHECK (fechaDevolucion > fechaPrestamo),
  FOREIGN KEY (idLibro) REFERENCES libro(idLibro),
  FOREIGN KEY (idLector) REFERENCES estudiante(idLector),
  PRIMARY KEY (idLector, idLibro)
);

-- Inserción de datos en la tabla libro
INSERT INTO libro (idLibro, titulo, editorial, area)
VALUES
  (1, 'Introducción a la Informática', 'Editorial Serpiente', 'Informática'),
  (2, 'La Magia de la Programación', 'Editorial Serpiente', 'Informática'),
  (3, 'Introducción a las BD', 'Editorial Salamandra', 'Base de Datos'),
  (4, 'Historia de la Informática', 'Editorial Serpiente', 'Historia'),
  (5, 'El Universo: Guía de viaje', 'Editorial Salamandra', 'Internet');

-- Inserción de datos en la tabla autor
INSERT INTO autor (idAutor, nombre, nacionalidad)
VALUES
  (1, 'Marie Dupont', 'Francesa'),
  (2, 'Giuseppe Rossi', 'Italiana'),
  (3, 'Sara Hernandez', 'Colombiana'),
  (4, 'Lucas Bianchi', 'Argentino'),
  (5, 'J.K. Rowling', 'Británica');

-- Inserción de datos en la tabla estudiante
INSERT INTO estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES
  (1, 'Laura', 'Gómez', 'Calle 1, Bogotá', 'Informática', 22),
  (2, 'Carlos', 'Martínez', 'Carrera 2, Medellín', 'Biología', 20),
  (3, 'Sofía', 'Rojas', 'Avenida 3, Cali', 'Informática', 21),
  (4, 'Filippo', 'Galli', 'Calle 4, Barranquilla', 'Historia', 23),
  (5, 'Gabriela', 'Pérez', 'Carrera 5, Cartagena', 'Informática', 19);

-- Inserción de datos en la tabla libroAutor
INSERT INTO libroAutor (idAutor, idLibro)
VALUES
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 5);

-- Inserción de datos en la tabla prestamo
INSERT INTO prestamo (idLector, idLibro, fechaPrestamo, fechaDevolucion, devuelto)
VALUES
  (1, 1, '2024-01-01', '2024-01-15', TRUE),
  (2, 2, '2024-01-02', '2024-01-16', FALSE),
  (3, 3, '2024-01-03', '2024-01-17', FALSE),
  (4, 4, '2024-01-04', '2024-01-18', TRUE),
  (5, 5, '2021-01-05', '2021-07-16', TRUE);
