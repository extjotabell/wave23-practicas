
DROP DATABASE IF EXISTS biblioteca_db;
CREATE DATABASE biblioteca_db;
USE biblioteca_db;

-- CREACION TABLAS:
CREATE TABLE Estudiante (
    idLector INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    direccion VARCHAR(100),
    carrera VARCHAR(50),
    edad INT
);

CREATE TABLE Autor (
    idAutor INT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    nacionalidad VARCHAR(50)
);

CREATE TABLE Libro (
    idLibro INT PRIMARY KEY,
    titulo VARCHAR(100),
    editorial VARCHAR(50),
    area VARCHAR(50)
);

CREATE TABLE LibroAutor (
    idLibro INT,
    idAutor INT,
    PRIMARY KEY (idLibro, idAutor),
    KEY libro_autor_idAutor (idAutor),
    KEY libro_autor_idLibro (idLibro),
    CONSTRAINT libro_autor_idAutor FOREIGN KEY (idAutor) REFERENCES Autor(idAutor),
    CONSTRAINT libro_autor_idLibro FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

CREATE TABLE Prestamo (
    idLector INT,
    idLibro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    devuelto BOOLEAN,
    PRIMARY KEY (idLector, idLibro),
    CONSTRAINT prestamo_idLector FOREIGN KEY (idLector) REFERENCES Estudiante(idLector),
    CONSTRAINT prestamo_idLibro FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);

-- INSERCIÓN:

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (1, 'Juan', 'Pérez', 'Calle A, Ciudad X', 'Informática', 20);

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (2, 'Ana', 'Gómez', 'Calle B, Ciudad Y', 'Medicina', 22);

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (3, 'Carlos', 'Martínez', 'Calle C, Ciudad Z', 'Informática', 21);

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (4, 'María', 'López', 'Calle D, Ciudad W', 'Economía', 23);

INSERT INTO Estudiante (idLector, nombre, apellido, direccion, carrera, edad)
VALUES (5, 'Filippo', 'Galli', 'Calle E, Ciudad V', 'Informática', 20);


INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (1, 'Introducción a la Programación', 'Editorial A', 'Informática');

INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (2, 'Historia del Arte', 'Editorial B', 'Arte');

INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (3, 'Economía para Principiantes', 'Salamandra', 'Economía');

INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (4, 'El Universo: Guía de viaje', 'Editorial D', 'Ciencias Naturales');

INSERT INTO Libro (idLibro, titulo, editorial, area)
VALUES (5, 'Poesía Contemporánea', 'Editorial E', 'Literatura');


INSERT INTO Autor (idAutor, nombre, apellido, nacionalidad)
VALUES (1, 'José', 'García', 'Española');

INSERT INTO Autor (idAutor, nombre, apellido, nacionalidad)
VALUES (2, 'María', 'Rodríguez', 'Mexicana');

INSERT INTO Autor (idAutor, nombre, apellido, nacionalidad)
VALUES (3, 'Carlos', 'Pérez', 'Colombiana');

INSERT INTO Autor (idAutor, nombre, apellido, nacionalidad)
VALUES (4, 'Laura', 'Martínez', 'Argentina');

INSERT INTO Autor (idAutor, nombre, apellido, nacionalidad)
VALUES (5, 'J.K', 'Rowling', 'Chilena');


INSERT INTO LibroAutor (idLibro, idAutor)
VALUES (1, 1); 

INSERT INTO LibroAutor (idLibro, idAutor)
VALUES (2, 2); 

INSERT INTO LibroAutor (idLibro, idAutor)
VALUES (3, 3); 

INSERT INTO LibroAutor (idLibro, idAutor)
VALUES (4, 4); 

INSERT INTO LibroAutor (idLibro, idAutor)
VALUES (5, 5); 


INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (3, 2, '2021-06-16', '2021-07-16', true);

INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (2, 2, '2023-02-15', '2023-03-10', false);

INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (3, 3, '2023-03-20', '2023-04-15', false);

INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (4, 4, '2023-04-05', '2023-05-01', true);

INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (5, 5, '2023-05-15', '2023-06-10', false);

INSERT INTO Prestamo (idLector, idLibro, fecha_prestamo, fecha_devolucion, devuelto)
VALUES (1, 2, '2024-01-05', '2024-02-01', false);

-- CONSULTAS:

-- 1. Listar los datos de los autores.

SELECT nombre, apellido, nacionalidad
FROM autor;

-- 2. Listar nombre y edad de los estudiantes

SELECT nombre, edad 
FROM estudiante
ORDER BY edad;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?

SELECT nombre, apellido 
FROM estudiante
WHERE carrera = 'Informática';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?

SELECT nombre, apellido 
FROM autor
WHERE nacionalidad = 'Francesa' OR nacionalidad =  'Italiana' ;

-- 5. ¿Qué libros no son del área de internet?

SELECT titulo, editorial
FROM libro
WHERE area != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.

SELECT titulo, area
FROM libro
WHERE editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.

SELECT nombre, apellido 
FROM estudiante
WHERE edad >  (SELECT AVG(edad)
			   FROM estudiante
                );

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.

SELECT nombre, apellido 
FROM estudiante
WHERE apellido like 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).

SELECT nombre
FROM autor
INNER JOIN libroautor ON autor.idautor = libroautor.idautor
INNER JOIN libro ON libro.idlibro = libroautor.idlibro
WHERE titulo = 'El Universo: Guía de viaje';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?

SELECT titulo, editorial
FROM libro
INNER JOIN prestamo ON prestamo.idLibro = libro.idLibro
INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector
WHERE estudiante.nombre = 'Filippo' AND estudiante.apellido = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.

SELECT nombre
FROM estudiante
WHERE edad =  (SELECT MIN(edad)
			   FROM estudiante)
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.

SELECT estudiante.nombre
FROM libro
INNER JOIN prestamo ON prestamo.idLibro = libro.idLibro
INNER JOIN estudiante ON prestamo.idLector = estudiante.idLector
WHERE libro.area = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.

SELECT libro.titulo
FROM libro
INNER JOIN libroautor ON libro.idlibro = libroautor.idlibro
INNER JOIN autor ON autor.idAutor = libroautor.idAutor
WHERE autor.nombre = 'J.K' and autor.apellido = 'Rowling';
 
-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT libro.titulo
FROM libro
INNER JOIN prestamo ON prestamo.idLibro = libro.idLibro
WHERE fecha_devolucion = '2021/07/16';


