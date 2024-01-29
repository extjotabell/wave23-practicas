
-- a. 
DROP DATABASE IF EXISTS empresa_internet;
CREATE DATABASE empresa_internet;
USE empresa_internet;


CREATE TABLE clientes (
  dni INT PRIMARY KEY,
  nombre VARCHAR(255),
  apellido VARCHAR(255),
  fecha_de_nacimiento DATE,
  provincia VARCHAR(255),
  ciudad VARCHAR(255)
);

CREATE TABLE planes_internet (
  plan_id INT PRIMARY KEY,
  velocidad INT,
  precio DOUBLE,
  descuento DOUBLE
);

CREATE TABLE planes_clientes (
  planes_clientes_id INT PRIMARY KEY,
  plan_internet_id INT,
  cliente_dni INT,  
  FOREIGN KEY (plan_internet_id) REFERENCES planes_internet(plan_id),
  FOREIGN KEY (cliente_dni) REFERENCES clientes(dni)
);

-- b. 
-- Inserciones en la tabla 'clientes'

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (123456789, 'Juan', 'Pérez', '1990-05-15', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (987654321, 'María', 'Gómez', '1985-08-22', 'Córdoba', 'Córdoba');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (456789123, 'Carlos', 'López', '1980-12-10', 'Santa Fe', 'Rosario');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (789123456, 'Ana', 'Rodríguez', '1995-03-25', 'Mendoza', 'Mendoza');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (321654987, 'Pedro', 'Fernández', '1982-07-18', 'Salta', 'Salta');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (654321789, 'Laura', 'Martínez', '1998-09-30', 'Córdoba', 'Córdoba');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (234567891, 'Diego', 'Sánchez', '1987-11-05', 'Mendoza', 'Mendoza');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (876543210, 'Silvia', 'García', '1992-04-08', 'Mendoza', 'Mendoza');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (135792468, 'Ricardo', 'Díaz', '1984-06-12', 'Mendoza', 'Mendoza');

INSERT INTO clientes (dni, nombre, apellido, fecha_de_nacimiento, provincia, ciudad)
VALUES (678901234, 'Lucía', 'Alvarez', '1993-02-20', 'Buenos Aires', 'Ciudad Autónoma de Buenos Aires');

-- Inserciones en la tabla 'planes_internet'

INSERT INTO planes_internet (plan_id, velocidad, precio, descuento)
VALUES (1, 50, 29.99, 5.00);

INSERT INTO planes_internet (plan_id, velocidad, precio, descuento)
VALUES (2, 100, 49.99, 7.50);

INSERT INTO planes_internet (plan_id, velocidad, precio, descuento)
VALUES (3, 110, 69.99, 10.00);

INSERT INTO planes_internet (plan_id, velocidad, precio, descuento)
VALUES (4, 300, 99.99, 15.00);

INSERT INTO planes_internet (plan_id, velocidad, precio, descuento)
VALUES (5, 200, 149.99, 20.00);

-- Inserciones en la tabla 'planes_clientes'
INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (1, 1, 123456789);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (2, 2, 987654321);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (3, 3, 456789123);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (4, 4, 789123456);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (5, 5, 321654987);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (6, 3, 654321789);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (7, 2, 234567891);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (8, 1, 876543210);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (9, 4, 135792468);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (10, 5, 678901234);

INSERT INTO planes_clientes (planes_clientes_id, plan_internet_id, cliente_dni)
VALUES (11, 2, 123456789);

-- Consultas:

-- 1. Obtener DNI del cliente con el mayor numero de planes adquiridos:

SELECT cliente_dni
FROM planes_clientes
GROUP BY cliente_dni
ORDER BY COUNT(plan_internet_id) DESC
LIMIT 1;

-- 2. Obtener DNI del cliente con el menor numero de planes adquiridos:

SELECT cliente_dni
FROM planes_clientes
GROUP BY cliente_dni
ORDER BY COUNT(plan_internet_id) ASC
LIMIT 1;

-- 3. Obtener la provincia con el mayor número de clientes:

SELECT provincia 
FROM (  SELECT provincia, COUNT(*) AS cantidad_clientes
		FROM clientes
		GROUP BY provincia
		ORDER BY cantidad_clientes DESC
		LIMIT 1 )AS subconsulta_provincia;

-- 4. Mostrar el id del plan y la cantidad de veces que ha sido adquirido ordenado de mayor a menor:

SELECT plan_internet_id, COUNT(*) AS cantidad_plan
FROM planes_clientes
GROUP BY plan_internet_id
ORDER BY cantidad_plan DESC;

-- 5. Obtener el id de los dos planes mas adquirido:

SELECT plan_internet_id, COUNT(*) AS cantidad_plan
FROM planes_clientes
GROUP BY plan_internet_id
ORDER BY cantidad_plan DESC
LIMIT 2;

-- 6. Obtener la edad promedio de los clientes:

SELECT AVG(edad) 
FROM (	SELECT YEAR(CURDATE()) - YEAR(fecha_de_nacimiento) AS edad
		FROM clientes) AS cientes_edad;
        
-- 7. Obtener la cantidad de clientes por provincia ordenado de mayor a menor:

SELECT provincia, COUNT(*) AS numero_clientes
FROM clientes
GROUP BY provincia
ORDER BY numero_clientes DESC;

-- 8. Obtener costo real de los planes con el descuento aplicado:

SELECT plan_id, precio - precio*(descuento/100) AS precio_final
FROM planes_internet;

-- 9. Obtener la información de los 3 clientes más jovenes y su edad:

SELECT nombre, apellido, YEAR(CURDATE()) - YEAR(fecha_de_nacimiento) AS edad
FROM clientes
ORDER BY fecha_de_nacimiento DESC
LIMIT 3;

-- 10. Obtener la información de los 5 clientes más longevos y su edad:

SELECT nombre, apellido, YEAR(CURDATE()) - YEAR(fecha_de_nacimiento) AS edad
FROM clientes
ORDER BY fecha_de_nacimiento ASC
LIMIT 5;






        

