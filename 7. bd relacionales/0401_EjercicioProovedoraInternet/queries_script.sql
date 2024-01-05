USE empresa_internet;

-- 1. Mostrar los clientes que hayan nacido desde el año 2000
SELECT * FROM cliente c WHERE c.fecha_nacimiento >= '20000101';

-- 2. Mostrar los planes de internet cuya velocidad sea mayor a 100 Mb
SELECT * FROM plan_internet pi WHERE pi.velocidad > 100;

-- 3. Mostrar los planes de internet cuyo precio sea menor o igual a 50.
SELECT * FROM plan_internet pi WHERE pi.precio <= 50;

-- 4. Mostrar los planes de internet cuyo descuento sea mayor o igual a 20.
SELECT * FROM plan_internet pi WHERE pi.descuento >= 20;

-- 5. Mostrar a los clientes cuyo apellido sea Sánchez.
SELECT * FROM cliente c WHERE c.apellido = 'Sánchez';

-- 6. Mostrar los planes de internet cuyo descuento sea mayor o igual a 10 y el precio sea menor o igual a 150.
SELECT * FROM plan_internet pi WHERE pi.descuento >= 10 AND pi.precio <= 150;

-- 7. Mostrar los planes de internet ordenados por velocidad.
SELECT * FROM plan_internet pi ORDER BY pi.velocidad;

-- 8. Mostrar los clientes ordenados por apellido
SELECT * FROM cliente c ORDER BY c.apellido;

-- 9. Mostrar los clientes cuya ciudad empiece con c
SELECT * FROM cliente c WHERE c.ciudad LIKE 'C%';

-- 10. Mostrar a los clientes cuyo nombre contenga "Juan" al inicio.
SELECT * FROM cliente c WHERE c.nombre LIKE 'Juan%';