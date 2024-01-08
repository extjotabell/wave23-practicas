-- 1. Listar los datos de los autores.
SELECT * FROM autor;

-- 2. Listar nombre y edad de los estudiantes
SELECT e.nombre, e.edad FROM estudiante e;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT * FROM estudiante e WHERE e.carrera = 'Computer Science';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT * FROM autor a WHERE a.nacionalidad = 'French' OR a.nacionalidad = 'Italian';

-- 5. ¿Qué libros no son del área de internet?
SELECT * FROM libro l WHERE l.área != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT * FROM libro l WHERE l.editorial = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT 
	* 
FROM 
	estudiante e
WHERE e.edad > (SELECT AVG(e.edad) FROM estudiante e);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT * FROM estudiante e WHERE e.apellido LIKE 'G%'; 

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT 
	a.nombre 
FROM 
	autor a
INNER JOIN libroautor la ON la.idAutor = a.idAutor
INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE 
	l.título = 'El Universo: Guía de viaje';
    
SELECT 
	a.nombre
FROM 
	autor a
INNER JOIN libroautor la ON la.idAutor = a.idAutor
INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE 
	l.título = 'Things Fall Apart';
    
    

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT 
	l.*
FROM 
	estudiante e
INNER JOIN prestamo p ON p.idLector = e.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE 
	e.nombre = 'Filippo' 
    AND e.apellido = 'Galli';

SELECT 
	l.*
FROM 
	estudiante e
INNER JOIN prestamo p ON p.idLector = e.idLector
INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE 
	e.nombre = 'John' 
    AND e.apellido = 'Doe';


-- 11. Listar el nombre del estudiante de menor edad.
SELECT
	e.nombre, 
    e.apellido
FROM
	estudiante e
ORDER BY 
	e.edad
LIMIT 1;


-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT 
	e.nombre, 
    e.apellido
FROM 
	libro l
INNER JOIN prestamo p ON p.idLibro = l.idLibro
INNER JOIN estudiante e ON e.idLector = p.idLector
WHERE
	l.área = 'Base de Datos';

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT 
	*
FROM
	autor a
INNER JOIN libroAutor la ON la.idAutor = a.idAutor
INNER JOIN libro l ON l.idLibro = la.idLibro
WHERE
	a.nombre = 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.

SELECT 
	l.*
FROM
	prestamo p
INNER JOIN libro l ON l.idLibro = p.idLibro
WHERE
	fechaDevolucion = '20210716';
