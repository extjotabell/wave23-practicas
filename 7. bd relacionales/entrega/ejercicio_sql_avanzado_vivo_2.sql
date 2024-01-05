select * from autor;

select Nombre,Edad from Estudiante;

select * from Estudiante where Carrera like "Computer Science";

select * from Autor where Nacionalidad In ("French","Italian");

select * from Libro where Área = "Internet";

select * from Libro where Editorial = "Salamandra";

select Nombre from Estudiante
where Edad > (select avg(Edad) from Estudiante);

select * from Estudiante where Apellido like "G%";

select Autor.Nombre,Libro.Título from Autor
left join LIBROAUTOR on Autor.idAutor = LIBROAUTOR.idautor
left join Libro on LibroAutor.idlibro = Libro.idlibro
where Libro.Título = "El Universo: Guía de viaje";

select libro.Título from estudiante
left join préstamo on estudiante.idLector = préstamo.idLector
left join libro on préstamo.idLibro = Libro.idLibro
where estudiante.Nombre = "Filippo Galli";

select * from estudiante where edad = (select min(edad) from estudiante);

select estudiante.nombre from estudiante
left join préstamo on estudiante.idLector = préstamo.idLector
left join libro on préstamo.idLibro = Libro.idLibro
where libro.área = "bbdd";

select Autor.Nombre,Libro.Título from Autor
left join LIBROAUTOR on Autor.idAutor = LIBROAUTOR.idautor
left join Libro on LibroAutor.idlibro = Libro.idlibro
where Autor.Nombre = "J.K. Rowling";

select * from Préstamo where fechaDevolucion = "2021-07-16";