-- Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.
SELECT empleado.nombre, empleado.puesto, departamento.nombre_depto
FROM departamento, empleado
WHERE empleado.depto_nro = departamento.depto_nro;

-- Visualizar los departamentos con más de cinco empleados.
SELECT departamento.depto_nro, COUNT(empleado.cod_emp) AS num_empleados
FROM departamento
JOIN empleado ON empleado.depto_nro = departamento.depto_nro
GROUP BY departamento.depto_nro
HAVING COUNT(empleado.cod_emp) > 5;

-- Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT empleado.nombre, empleado.salario, departamento.nombre_depto
FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE empleado.puesto = (
						SELECT empleado.puesto 
						FROM empleado 
						WHERE empleado.nombre = "Mito" 
                        AND empleado.apellido = "Barchuk");
                        
-- Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT *
FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = "Contabilidad"
ORDER BY empleado.nombre;

-- Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT nombre
FROM empleado
ORDER BY salario ASC
limit 1;

-- Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT empleado.*
FROM empleado
JOIN departamento ON empleado.depto_nro = departamento.depto_nro
WHERE departamento.nombre_depto = "Ventas"
ORDER BY empleado.salario DESC
limit 1;



# Ejercicio 2
-- Listar los datos de los autores.
SELECT * FROM Autor;

-- Listar nombre y edad de los estudiantes
SELECT Nombre, Edad FROM Estudiante;

-- ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM Estudiante WHERE Carrera = "Computer Science";

-- ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM Autor WHERE Nacionalidad IN ("Italian", "French");

-- ¿Qué libros no son del área de internet?
SELECT * FROM Libro WHERE Área="Internet";

-- Listar los libros de la editorial Salamandra.
SELECT * FROM Libro WHERE Editorial="Salamandra";

-- Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT * FROM Estudiante WHERE Edad > (SELECT AVG(Edad) FROM Estudiante);

-- Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM Estudiante WHERE Apellido LIKE 'G%';

-- Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT Autor.Nombre 
FROM Autor 
JOIN LibroAutor ON Autor.idAutor = LibroAutor.idAutor
JOIN Libro ON LibroAutor.idLibro = Libro.idLibro
WHERE Libro.Título = "El Universo: Guía de viaje";

-- ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT Libro.Título
FROM Libro
INNER JOIN Préstamo ON Préstamo.idLibro = Libro.idLibro
INNER JOIN Estudiante ON Préstamo.idLector = Estudiante.idLector
WHERE Estudiante.Nombre = "Filippo" AND Estudiante.Apellido = "Galli";

-- Listar el nombre del estudiante de menor edad.
SELECT *
FROM Estudiante
ORDER BY Edad ASC
LIMIT 1;

-- Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT Estudiante.Nombre, Estudiante.Apellido
FROM Estudiante
INNER JOIN Préstamo ON Préstamo.idLector = Estudiante.idLector;

-- Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT Libro.*
FROM Libro
INNER JOIN LibroAutor ON LibroAutor.idLibro = Libro.idLibro
INNER JOIN Autor ON LibroAutor.idAutor = Autor.idAutor
WHERE Autor.Nombre = "J.K. Rowling";

-- Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT Libro.*
FROM Libro
INNER JOIN Préstamo ON Préstamo.idLibro = Libro.idLibro
WHERE Préstamo.FechaDevolucion="2021-07-16";