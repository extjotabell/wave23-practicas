#Listar los datos de los autores.
SELECT * FROM Biblioteca.Autor;

#Listar nombre y edad de los estudiantes.
select nombre, edad
from estudiante;

#¿Qué estudiantes pertenecen a la carrera informática?
select *
from estudiante
where carrera = 'Computer science';

#¿Qué autores son de nacionalidad francesa o italiana?
select *
from autor
where nacionalidad in ('Italian', 'French');

#¿Qué libros no son del área de internet?
select *
from libro
where área != 'Internet';

#Listar los libros de la editorial Salamandra.
select *
from libro
where editorial='salamandra';

#Listar los datos de los estudiantes cuya edad es mayor al promedio.
select * from estudiante
where edad > (select avg(edad) from estudiante);

#Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
select nombre from estudiante
where apellido like 'G%';

#Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
select nombre from autor
inner join libroautor
on libroautor.idAutor= autor.idAutor
inner join libro
on libro.idLibro = libroautor.idLibro
where libro.título = 'El Universo: Guía de viaje';

#¿Qué libros se prestaron al lector “Filippo Galli”?
select título from libro
inner join préstamo
on préstamo.idLibro = libro.idLibro
inner join estudiante
on estudiante.idLector = préstamo.idLector
where estudiante.nombre = 'Filippo' and estudiante.apellido = 'Galli';

#Listar el nombre del estudiante de menor edad.
select nombre from estudiante
order by edad asc
limit 1;

#Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
select nombre from estudiante
inner join préstamo
on estudiante.idLector = préstamo.idLector
inner join libro
on libro.idLibro = préstamo.idLibro
where libro.área = 'data base';

#Listar los libros que pertenecen a la autora J.K. Rowling.
select título from libro
inner join libroautor
on libro.idLibro = libroautor.idLibro
inner join autor
on autor.idAutor = libroautor.idAutor
where autor.nombre = 'J.K. Rowling';

#Listar títulos de los libros que debían devolverse el 16/07/2021
select título from libro
inner join préstamo
on préstamo.idLibro = libro.idLibro
where préstamo.fechadevolucion = '2021-07-16'
