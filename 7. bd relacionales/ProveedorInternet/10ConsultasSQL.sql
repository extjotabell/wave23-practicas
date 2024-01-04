-- Listar los clientes y la información de sus planes de internet:
SELECT clientes.*, planes_internet.*
FROM clientes
JOIN contratos ON clientes.dni = contratos.cliente_dni
JOIN planes_internet ON contratos.plan_id = planes_internet.plan_id;

-- Obtener la velocidad promedio de todos los planes de internet:
SELECT AVG(velocidad_megas) AS velocidad_promedio
FROM planes_internet;

-- Encontrar el plan de internet más caro:
SELECT *
FROM planes_internet
ORDER BY precio DESC
LIMIT 1;

-- Calcular el total de contratos por provincia:
SELECT provincia, COUNT(*) AS total_contratos
FROM clientes
JOIN contratos ON clientes.dni = contratos.cliente_dni
GROUP BY provincia;

-- Mostrar los clientes que no tienen contratos:
SELECT clientes.*
FROM clientes
LEFT JOIN contratos ON clientes.dni = contratos.cliente_dni
WHERE contratos.cliente_dni IS NULL;

-- Encontrar los clientes que contrataron planes con descuento:
SELECT clientes.*
FROM clientes
JOIN contratos ON clientes.dni = contratos.cliente_dni
JOIN planes_internet ON contratos.plan_id = planes_internet.plan_id
WHERE planes_internet.descuento > 0;

-- Encontrar los contratos firmados después de una fecha específica:
SELECT *
FROM contratos
WHERE fecha_contrato > '2023-01-01';

-- Obtener todos los clientes y sus contratos:
SELECT clientes.*, contratos.*
FROM clientes
JOIN contratos ON clientes.dni = contratos.cliente_dni;

-- Calcular el total de ingresos por contratos agrupados por mes:
SELECT MONTH(fecha_contrato) AS mes, SUM(precio) AS ingresos_totales
FROM contratos
JOIN planes_internet ON contratos.plan_id = planes_internet.plan_id
GROUP BY mes;

-- Calcular el total de clientes por ciudad que tienen planes con descuento:
SELECT ciudad, COUNT(*) AS total_clientes
FROM clientes
JOIN contratos ON clientes.dni = contratos.cliente_dni
JOIN planes_internet ON contratos.plan_id = planes_internet.plan_id
WHERE planes_internet.descuento > 0
GROUP BY ciudad;