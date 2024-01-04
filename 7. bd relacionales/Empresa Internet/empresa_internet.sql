-- Creamos DB
CREATE SCHEMA `empresa_internet`;


-- Creamos tablas
CREATE TABLE `clientes` (
  `id_cliente` Integer PRIMARY KEY,
  `nombre` varchar(255),
  `apellido` varchar(255),
  `fecha_nac` date,
  `id_provincia` Integer,
  `id_ciudad` Integer,
  `id_plan_internet` Integer,
  CONSTRAINT `fk_id_provincia` FOREIGN KEY (`id_provincia`) REFERENCES `provincias` (`id_provincia`),
  CONSTRAINT `fk_id_ciudad` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudades` (`id_ciudad`),
  CONSTRAINT `fk_id_plan_internet` FOREIGN KEY (`id_plan_internet`) REFERENCES `planes_internet` (`id_plan_internet`)
);

CREATE TABLE `provincias` (
  `id_provincia` Integer PRIMARY KEY,
  `nombre` varchar(255)
);

CREATE TABLE `ciudades` (
  `id_ciudad` Integer PRIMARY KEY,
  `nombre` varchar(255)
);

CREATE TABLE `planes_internet` (
  `id_plan_internet` Integer PRIMARY KEY,
  `velocidad` Integer,
  `precio` float,
  `descuento` float
);


-- Agregamos ciudades
INSERT INTO ciudades VALUES
(1, "Buenos Aires"),
(2, "Córdoba"),
(3, "Rosario");


-- Agregamos provincias
INSERT INTO provincias VALUES
(1, "Buenos Aires"),
(2, "Córdoba"),
(3, "Santa Fe");


-- Agregamos planes de internet
INSERT INTO planes_internet VALUES
(1, 10, 29.99, 0.05),
(2, 20, 39.99, 0.1),
(3, 50, 59.99, 0.15),
(4, 100, 79.99, 0.2),
(5, 200, 99.99, 0.25);


-- Agregamos clientes
INSERT INTO clientes VALUES
(1, 'Juan', 'Gómez', '1990-05-15', 1, 1, 1),
(2, 'María', 'López', '1985-08-23', 2, 2, 2),
(3, 'Carlos', 'Rodríguez', '1988-12-10', 3, 3, 3),
(4, 'Laura', 'Fernández', '1992-04-05', 1, 1, 4),
(5, 'Pedro', 'Martínez', '1980-06-20', 2, 2, 5),
(6, 'Ana', 'García', '1995-09-30', 3, 3, 1),
(7, 'Sergio', 'Díaz', '1983-11-18', 1, 1, 2),
(8, 'Elena', 'Vargas', '1998-02-25', 2, 2, 3),
(9, 'Pablo', 'Hernández', '1987-07-12', 3, 3, 4),
(10, 'Carmen', 'Sánchez', '1993-03-08', 1, 1, 5);


-- Consultas
-- 1) Seleccionar el id de los clientes nacidos después de 1990
SELECT id_cliente FROM clientes WHERE fecha_nac > '1990-01-01'; 

-- 2) Seleccionar el id y nombre de los clientes cuyo nombre empiece con la letra C
SELECT id_cliente, nombre FROM clientes WHERE nombre LIKE "C%";

-- 3) Seleccionar el id de los planes de internet que superen los 10 megas de velocidad
SELECT id_plan_internet FROM planes_internet WHERE velocidad > 10;

-- 4) Seleccionar el precio promedio de los planes de internet disponibles
SELECT AVG(precio) precio_promedio FROM planes_internet;

-- 5) Seleccionar todos los planes de internet cuyo precio sea menor a 50
SELECT id_plan_internet, precio FROM planes_internet WHERE precio < 50;

-- 6) Seleccionar el id de los planes de internet que superen los 15 megas de velocidad y tengan un descuento mayor al 20%
SELECT id_plan_internet FROM planes_internet WHERE velocidad > 10 AND descuento > 0.20;

-- 7) Seleccionar los primeros dos clientes que vivan en la ciudad de Buenos Aires ordenados ascendentemente
SELECT c.id_cliente, c.nombre, c.apellido, ciu.nombre
FROM clientes c, ciudades ciu
WHERE c.id_ciudad = ciu.id_ciudad AND
	  ciu.nombre = "Buenos Aires"
ORDER BY c.id_cliente, c.nombre, c.apellido, ciu.nombre
LIMIT 2;

-- 8) Seleccionar la cantidad de clientes que viven en la ciudad de Buenos Aires y que tienen una velocidad de internet de 10 megas
SELECT count(*)
FROM clientes c, ciudades ciu, planes_internet pi
WHERE c.id_ciudad = ciu.id_ciudad AND
	  c.id_plan_internet = pi.id_plan_internet AND
      ciu.nombre = "Buenos Aires" AND
      pi.velocidad = 10;

-- 9) Seleccionar nombre y apellido de todos los clientes de la provincia de Buenos Aires ordenados descendente
SELECT c.nombre, c.apellido
FROM clientes c, provincias p
WHERE c.id_provincia = p.id_provincia AND
	  p.nombre = "Buenos Aires"
ORDER BY c.nombre DESC, c.apellido DESC;

-- 10) Seleccionar todos los clientes de la provincia de Córdoba que tengan un plan de internet con una velocidad mayor a 10 megas
SELECT c.id_cliente, c.nombre, c.apellido, p.nombre, pi.velocidad
FROM clientes c, provincias p, planes_internet pi
WHERE c.id_provincia = p.id_provincia AND
	  c.id_plan_internet = pi.id_plan_internet AND
      p.nombre = "Córdoba" AND
      pi.velocidad > 10;