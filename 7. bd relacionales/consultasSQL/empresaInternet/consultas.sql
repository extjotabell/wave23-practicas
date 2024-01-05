-- 1 Contar la cantidad de clientes por número de plan
SELECT
    COUNT(*) as cantidad_cliente,
    FKidPlan as numero_plan
FROM
    cliente
GROUP BY
    FKidPlan;

-- 2 Actualizar el plan del cliente con ID 1 a 3
UPDATE
    cliente
SET
    FKidPlan = 3
WHERE
    idCliente = 1;

-- 3 Obtener la velocidad máxima de los planes
SELECT
    MAX(velocity) as velocidad_maxima
FROM
    planes;

-- 4 Calcular el promedio de precios de los planes
SELECT
    AVG(price) as promedio_precios
FROM
    planes;

-- 5 Seleccionar nombres y fechas de nacimiento de clientes nacidos entre 1990-01-01 y 2000-01-01
SELECT
    name,
    birthdate
FROM
    cliente
WHERE
    birthdate BETWEEN "1990-01-01" AND "2000-01-01";

-- 6 Seleccionar nombres de clientes que comienzan con "J"
SELECT
    name
FROM
    cliente
WHERE
    name LIKE "J%";

-- 7 Seleccionar nombre, apellido y velocidad de clientes con la información de los planes
SELECT
    name,
    lastName,
    velocity
FROM
    cliente
LEFT JOIN planes ON FKidPlan = planes.idPlan;

-- 8 Calcular la edad de los clientes
SELECT
    idCliente,
    name,
    lastName,
    DATEDIFF(CURRENT_DATE(), birthdate) / 365 AS age
FROM
    cliente;

-- 9 Seleccionar el cliente más joven
SELECT
    idCliente,
    name,
    lastName,
    DATEDIFF(CURRENT_DATE(), birthdate) / 365 AS age
FROM
    cliente
ORDER BY
    age ASC
LIMIT 1;

-- 10 Encontrar el descuento mínimo en los planes
SELECT
    MIN(discount)
FROM
    planes;