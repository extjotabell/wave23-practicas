-- Contar la cantidad de clientes por número de plan
SELECT
    COUNT(*) as cantidad_cliente,
    FK_plan_id as numero_plan
FROM
    cliente
GROUP BY
    FK_plan_id;

-- Actualizar el plan del cliente con ID 1 a 3
UPDATE
    cliente
SET
    FK_plan_id = 3
WHERE
    id = 1;

-- Obtener la velocidad máxima de los planes
SELECT
    MAX(velocity) as velocidad_maxima
FROM
    planes;

-- Calcular el promedio de precios de los planes
SELECT
    AVG(price) as promedio_precios
FROM
    planes;

-- Seleccionar nombres y fechas de nacimiento de clientes nacidos entre 1990-01-01 y 2000-01-01
SELECT
    name,
    birthdate
FROM
    cliente
WHERE
    birthdate BETWEEN "1990-01-01" AND "2000-01-01";

-- Seleccionar nombres de clientes que comienzan con "J"
SELECT
    name
FROM
    cliente
WHERE
    name LIKE "J%";

-- Seleccionar nombre, apellido y velocidad de clientes con la información de los planes
SELECT
    name,
    last_name,
    velocity
FROM
    cliente
LEFT JOIN planes ON FK_plan_id = planes.id;

-- Calcular la edad de los clientes
SELECT
    id,
    name,
    last_name,
    DATEDIFF(CURRENT_DATE(), birthdate) / 365 AS age
FROM
    cliente;

-- Seleccionar el cliente más joven
SELECT
    id,
    name,
    last_name,
    DATEDIFF(CURRENT_DATE(), birthdate) / 365 AS age
FROM
    cliente
ORDER BY
    age ASC
LIMIT 1;

-- Encontrar el descuento mínimo en los planes
SELECT
    MIN(discount)
FROM
    planes;

-- Insert data into the `planes` table
INSERT INTO `planes` (`id`, `velocity`, `price`, `discount`) VALUES
(1, 100, 29.99, 0.1),
(2, 200, 39.99, 0.15),
(3, 300, 49.99, 0.2),
(4, 400, 59.99, 0.25),
(5, 500, 69.99, 0.3);

-- Insert data into the `cliente` table
INSERT INTO `cliente` (`id`, `name`, `last_name`, `dni`, `birthdate`, `province`, `city`, `FK_plan_id`) VALUES
(1, 'John', 'Doe', 123456789, '1990-01-01', 'Province1', 'City1', 1),
(2, 'Jane', 'Smith', 987654321, '1995-02-15', 'Province2', 'City2', 2),
(3, 'Mike', 'Johnson', 456789123, '1988-05-20', 'Province3', 'City3', 3),
(4, 'Emily', 'Williams', 654321987, '1992-09-10', 'Province4', 'City4', 4),
(5, 'David', 'Brown', 789123456, '1985-11-30', 'Province5', 'City5', 5),
(6, 'Sophia', 'Miller', 321654987, '1998-03-25', 'Province1', 'City1', 1),
(7, 'Daniel', 'Wilson', 159753468, '1987-07-12', 'Province2', 'City2', 2),
(8, 'Olivia', 'Jones', 852369741, '1993-04-18', 'Province3', 'City3', 3),
(9, 'Ethan', 'Anderson', 147258369, '1996-08-05', 'Province4', 'City4', 4),
(10, 'Ava', 'Taylor', 369147258, '1989-12-22', 'Province5', 'City5', 5);
