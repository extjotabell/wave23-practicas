use empresa_internet;
CREATE TABLE Cliente (
  cliente_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dni INT NOT NULL,
  nombre VARCHAR(50) NOT NULL,
  apellido VARCHAR(50) NOT NULL,
  fecha_nacimiento DATE NOT NULL,
  provincia VARCHAR(50),
  ciudad VARCHAR(50),
  plan_id INT NOT NULL
);

CREATE TABLE Plan (
  plan_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  descripcion VARCHAR(75) NOT NULL,
  velocidad INT NOT NULL,
  precio DECIMAL(10,2) NOT NULL,
  descuento DECIMAL(10,2) NOT NULL
);

INSERT INTO Cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad, plan_id)
VALUES
  (123456789, 'Juan', 'Perez', '1990-01-15', 'Buenos Aires', 'Avellaneda', 1),
  (987654321, 'Maria', 'Lopez', '1985-05-20', 'Cordoba', 'Cordoba', 2),
  (555555555, 'Carlos', 'Gomez', '1992-11-08', 'Mendoza', 'Luján de Cuyo', 5),
  (123456134, 'Julian', 'Matinez', '2000-01-15', 'Entre Rios', 'Colon', 3),
  (987674321, 'Marcos', 'Diaz', '1997-05-20', 'Rio Negro', 'Bariloche', 4),
  (553515555, 'Laura', 'Ramirez', '1998-11-08', 'Mendoza', 'Luján de Cuyo', 5),
  (129873789, 'Camila', 'Rubio', '2001-01-15', 'Buenos Aires', 'Nuñez', 1),
  (913431567, 'Brenda', 'Roldan', '2003-05-20', 'Cordoba', 'Villa Carlos Paz', 2),
  (123555555, 'Valentina', 'Gonzalez', '1978-11-08', 'Buenos Aires', 'Tigre', 3),
  (587361555, 'Nicolas', 'Martino', '1981-11-08', 'Mendoza', 'San Rafael', 2);
  
INSERT INTO Plan (descripcion, velocidad, precio, descuento)
VALUES
  ('Plan Básico', 50, 2900.99, 0.00),
  ('Plan Flex', 100, 4900.99, 0.1),
  ('Plan Plus', 300, 8900.99, 0.2),
  ('Plan Full', 600, 14900.99, 0.25),
  ('Plan Premium', 1000, 20900.99, 0.3);
  
-- Mostrar nombre y apellido de los clientes que tengan el Plan Premium (5)
select concat(nombre, " ", apellido) as Cliente from Cliente where plan_id = 5;
-- Mostrar nombre y apellido de los clientes que sean de Buenos Aires
select concat(nombre, " ", apellido) as Cliente from Cliente where provincia like "Buenos Aires";
-- Mostrar descripcion de los planes que tengan precio mayor a $5000
select descripcion from Plan where precio > 5000;
-- Mostrar precio promedio de los planes sin descuento
select round(avg(precio), 2) from Plan;
-- Calcular precio de los planes con descuento incluido
select descripcion as Plan, round(precio - (precio * descuento),2) as "Precio con descuento" from Plan;
-- Mostrar clientes ordenados por apellido
select concat(apellido, " ", nombre) as Cliente from Cliente order by apellido;
-- Mostrar cliente y plan ordenados por edad asc
select concat(nombre, " ", apellido) as Cliente, timestampdiff(year, fecha_nacimiento, curdate()) as Edad from Cliente order by timestampdiff(year, fecha_nacimiento, curdate()) asc;
-- Mostrar descripcion y id del plan más caro 
select precio, descripcion from Plan order by precio desc limit 1;
-- Mostrar descripcion y id del plan más económico
select precio, descripcion from Plan order by precio limit 1;
-- Mostrar planes ordenados por megas desc 
select * from Plan order by velocidad desc

  

