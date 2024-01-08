CREATE DATABASE IF NOT EXISTS library;
USE library;
CREATE TABLE author
(
  id_author INT ,
  name_author VARCHAR(50),
  nacionality_author VARCHAR(50) ,
  CONSTRAINT PK_author PRIMARY KEY (id_author)
);
CREATE TABLE book
(
  id_book INT,
  title_book VARCHAR(100) ,
  editorial_book VARCHAR(50) ,
  area_book VARCHAR(50) ,
  CONSTRAINT PK_book PRIMARY KEY (id_book)
);
CREATE TABLE book_author
(
  id_author INT,
  id_book INT,
  CONSTRAINT PK_book_author PRIMARY KEY (id_author, id_book),
  CONSTRAINT FK_book_author_author FOREIGN KEY (id_author) REFERENCES author (id_author),
  CONSTRAINT FK_book_author_book FOREIGN KEY (id_book) REFERENCES book (id_book)
);
CREATE TABLE student
(
  id_reader INT,
  name_student VARCHAR(50) ,
  last_name_student VARCHAR(50) ,
  address_student VARCHAR(100) ,
  programm_student VARCHAR(50) ,
  age_student INT ,
  CONSTRAINT PK_student PRIMARY KEY (id_reader)
);
CREATE TABLE loan
(
  id_reader INT,
  id_book INT,
  date_loan DATE ,
  date_refund_loan DATE,
  refund_loan BIT ,
  CONSTRAINT PK_loan PRIMARY KEY (id_reader, id_book),
  CONSTRAINT FK_loan_student FOREIGN KEY (id_reader) REFERENCES student (id_reader),
  CONSTRAINT FK_loan_book FOREIGN KEY (id_book) REFERENCES book (id_book)
);
-- Insert data into author table
INSERT INTO author (id_author, name_author, nacionality_author) VALUES
(1, 'Gabriel Garcia Marquez', 'Colombian'),
(2, 'Jane Austen', 'English'),
(3, 'Haruki Murakami', 'Japanese'),
(4, 'J.K. Rowling', 'British'),
(5, 'Antoine de Saint-Exupér', 'French'),
(6, 'Dante Allighieri', 'Italian'),
(7, 'Various Authors', 'American');


-- Insert data into book table
INSERT INTO book (id_book, title_book, editorial_book, area_book) VALUES
(1, 'One Hundred Years of Solitude', 'Vintage Books', 'Magical Realism'),
(2, 'Pride and Prejudice', 'Penguin Classics', 'Classic Fiction'),
(3, 'Norwegian Wood', 'Salamandra', 'Contemporary Fiction'),
(4, 'Harry Potter and the Sorcerer''s Stone', 'Scholastic', 'Fantasy'),
(5, 'The Little Prince', 'Gallimard ', 'Novella'),
(6, 'Divine Comedy', 'Foligno ', 'Narrative Poem'),
(7, 'The Universe', 'Lonely Planet ', 'Internet');

-- Insert data into book_author table
INSERT INTO book_author (id_author, id_book) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7);

-- Insert data into student table
INSERT INTO student (id_reader, name_student, last_name_student, address_student, programm_student, age_student) VALUES
(1, 'John', 'Doe', '123 Main St', 'Computer Science', 20),
(2, 'Alice', 'Smith', '456 Oak St', 'Literature', 22),
(3, 'Bob', 'Johnson', '789 Pine St', 'Physics', 21),
(4, 'Emma', 'Williams', '101 Elm St', 'Medicine', 23),
(5, 'Filippo', 'Galli', '202 Maple St', 'History', 22),
(6, 'Andres', 'Limpio', '555 Mexico', 'Computer Science', 30);

-- Insert data into loan table
INSERT INTO loan (id_reader, id_book, date_loan, date_refund_loan, refund_loan) VALUES
(1, 1, '2023-01-01', '2023-01-15', 1),
(2, 2, '2023-02-01', '2023-02-15', 1),
(3, 3, '2023-03-01', '2023-03-15', 0),
(4, 4, '2023-04-01', NULL, 0),
(5, 5, '2023-05-01', NULL, 0),
(6, 7, '2021-07-08', '2021-07-16', 0);

-- 1. Listar los datos de los autores.
SELECT * FROM author;

-- 2. Listar nombre y edad de los estudiantes
SELECT student.name_student, student.age_student
FROM student;

-- 3. ¿Qué estudiantes pertenecen a la carrera informática?
SELECT *
FROM student
WHERE programm_student = 'Computer Science';

-- 4. ¿Qué autores son de nacionalidad francesa o italiana?
SELECT *
FROM author
WHERE nacionality_author = 'French' OR  nacionality_author = 'Italian';

-- 5. ¿Qué libros no son del área de internet?
SELECT *
FROM book
WHERE area_book != 'Internet';

-- 6. Listar los libros de la editorial Salamandra.
SELECT *
FROM book
WHERE editorial_book = 'Salamandra';

-- 7. Listar los datos de los estudiantes cuya edad es mayor al promedio.
SELECT *
FROM student
WHERE age_student > (
    SELECT AVG(age_student)
    FROM student
);

-- 8. Listar los nombres de los estudiantes cuyo apellido comience con la letra G.
SELECT name_student
FROM student
WHERE last_name_student LIKE 'G%';

-- 9. Listar los autores del libro “El Universo: Guía de viaje”. (Se debe listar solamente los nombres).
SELECT name_author
FROM author
INNER JOIN book_author ON author.id_author = book_author.id_author
INNER JOIN book ON book.id_book = book_author.id_book
WHERE  title_book = 'The Universe';

-- 10. ¿Qué libros se prestaron al lector “Filippo Galli”?
SELECT book.*
FROM book 
INNER JOIN loan ON loan.id_book = book.id_book
INNER JOIN student ON loan.id_reader = student.id_reader
WHERE student.name_student = 'Filippo' AND student.last_name_student = 'Galli';

-- 11. Listar el nombre del estudiante de menor edad.
SELECT name_student
FROM student
ORDER BY age_student ASC
LIMIT 1;

-- 12. Listar nombres de los estudiantes a los que se prestaron libros de Base de Datos.
SELECT name_student
FROM student
INNER JOIN loan ON loan.id_reader = student.id_reader
WHERE refund_loan = 1;

-- 13. Listar los libros que pertenecen a la autora J.K. Rowling.
SELECT book.*
FROM book
INNER JOIN book_author ON book.id_book = book_author.id_author
INNER JOIN author ON author.id_author = book_author.id_author
WHERE author.name_author LIKE 'J.K. Rowling';

-- 14. Listar títulos de los libros que debían devolverse el 16/07/2021.
SELECT book.*
FROM book
INNER JOIN loan ON loan.id_book = book.id_book
WHERE loan.date_refund_loan = '2021-07-16';