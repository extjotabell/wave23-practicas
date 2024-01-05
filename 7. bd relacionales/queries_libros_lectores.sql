select * from autor;

select nombre, edad from estudiante;

select * from estudiante where carrera = informatica;

select * from autor where nacionalidad in ('Francesa', 'Italiana');

select * from libro where area != 'Internet';

select * from libro where editorial = 'Salamandra';

select * from estudiante where edad > (select avg(edad) from estudiante);

select nombre from estudiante where apellido like 'G%';

select autor.nombre from autor
join libro_autor on autor.idAutor = libro_autor.idAutor
join libro on libro.idLibro = libro_autor.idLibro
where libro.titulo = 'El Universo: Guía de viaje';

select libro.titulo from libro
join prestamo on libro.idLibro = prestamo.idLibro
join estudiante on prestamo.idLector = estudiante.idLector
where estudiante.nombre = 'Filippo Galli';

select nombre from estudiante
where edad = (select min(edad) from estudiante);

select distinct estudiante.nombre from estudiante
join prestamo on estudiante.idLector = prestamo.idLector
join libro on prestamo.idLibro = libro.idLibro
where libro.area = 'Base de datos';
