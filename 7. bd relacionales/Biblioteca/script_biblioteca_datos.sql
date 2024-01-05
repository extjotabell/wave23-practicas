-- Creamos DB
CREATE SCHEMA `biblioteca`;


-- Creamos tablas
CREATE TABLE `autores` (
  `id_autor` Integer PRIMARY KEY,
  `nombre` varchar(255),
  `nacionalidad` varchar(255)
);

CREATE TABLE `libros` (
  `id_libro` Integer PRIMARY KEY,
  `titulo` varchar(255),
  `editorial` varchar(255),
  `area` varchar(255)
);

CREATE TABLE `estudiantes` (
  `id_lector` Integer PRIMARY KEY,
  `nombre` varchar(255),
  `apellido` varchar(255),
  `direccion` varchar(255),
  `carrera` varchar(255),
  `edad` Integer
);

CREATE TABLE `libros_autores` (
  `id_autor` Integer,
  `id_libro` Integer,
  PRIMARY KEY (`id_autor`, `id_libro`),
  CONSTRAINT `fk_id_autor` FOREIGN KEY (`id_autor`) REFERENCES `autores` (`id_autor`),
  CONSTRAINT `fk_id_libro` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro`)
);

CREATE TABLE `prestamos` (
  `id_lector` Integer,
  `id_libro` Integer,
  `fecha_prestamo` date,
  `fecha_devolucion` date,
  `devuelto` boolean,
  PRIMARY KEY (`id_lector`, `id_libro`),
  CONSTRAINT `fk_id_lector` FOREIGN KEY (`id_lector`) REFERENCES `estudiantes` (`id_lector`),
  CONSTRAINT `fk_id_libro2` FOREIGN KEY (`id_libro`) REFERENCES `libros` (`id_libro`)
);


-- Inserts para la tabla 'autores'
INSERT INTO autores (id_autor, nombre, nacionalidad) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombiano'),
(2, 'Haruki Murakami', 'Japonés'),
(3, 'J.K. Rowling', 'Británica'),
(4, 'Isabel Allende', 'Chilena'),
(5, 'George Orwell', 'Británico'),
(6, 'Autor frances', 'Francesa'),
(7, 'Autor italiano', 'Italiana');

-- Inserts para la tabla 'libros'
INSERT INTO libros (id_libro, titulo, editorial, area) VALUES
(101, 'Cien años de soledad', 'Editorial Sudamericana', 'Ficción'),
(102, 'Norwegian Wood', 'Shinchosha', 'Ficción'),
(103, 'Harry Potter and the Philosopher''s Stone', 'Bloomsbury', 'Fantasía'),
(104, 'La Casa de los Espíritus', 'Plaza & Janés', 'Ficción'),
(105, '1984', 'Secker & Warburg', 'Ciencia Ficción'),
(106, 'Libro Salamandra', 'Salamandra', 'Ficción'),
(107, 'El Universo: Guía de viaje', 'Editorial Marcos', 'Horror'),
(108, 'SQL Basico', 'Señor SQL', 'Base de Datos');

-- Inserts para la tabla 'estudiantes'
INSERT INTO estudiantes (id_lector, nombre, apellido, direccion, carrera, edad) VALUES
(1001, 'Juan', 'Perez', 'Calle 123', 'Ciencias de la Computación', 20),
(1002, 'Maria', 'Gomez', 'Avenida 456', 'Ingeniería Civil', 22),
(1003, 'Carlos', 'Rodriguez', 'Carrera 789', 'Medicina', 21),
(1004, 'Ana', 'Lopez', 'Avenida 987', 'Arquitectura', 23),
(1005, 'Pedro', 'Martinez', 'Calle 654', 'Derecho', 24),
(1006, 'Marcos', 'Costanzo', 'Marcos 123', 'Informática', 25),
(1007, 'Filippo', 'Galli', 'Filippo 987', 'Informática', 30);

-- Inserts para la tabla 'libros_autores'
INSERT INTO libros_autores (id_autor, id_libro) VALUES
(1, 101),
(2, 102),
(3, 103),
(4, 104),
(5, 105),
(6, 106),
(7, 107),
(3, 108);

-- Inserts para la tabla 'prestamos'
INSERT INTO prestamos (id_lector, id_libro, fecha_prestamo, fecha_devolucion, devuelto) VALUES
(1001, 101, '2023-01-01', '2023-01-15', true),
(1002, 102, '2023-02-01', '2023-02-15', false),
(1003, 103, '2023-03-01', '2021-07-16', false),
(1004, 104, '2023-04-01', '2023-04-15', false),
(1005, 105, '2023-05-01', '2023-05-15', true),
(1007, 107, '2023-06-01', NULL, false),
(1006, 108, '2023-08-01', NULL, false);