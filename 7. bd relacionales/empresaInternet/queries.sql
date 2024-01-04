-- 1. Obtener todos los clientes
SELECT * FROM Cliente;

-- 2. Listar todos los contratos y los clientes asociados:
SELECT
	Contrato.id id_contrato,
    CONCAT(Cliente.nombre, ' '  ,Cliente.apellido) cliente,
    Plan.velocidad_megas,
    Plan.precio
FROM Contrato INNER JOIN Cliente ON Contrato.dni_cliente = Cliente.dni

INNER JOIN Plan ON Contrato.id_plan = Plan.id;

-- 3. Calcular el promedio de velocidad de todos los planes
SELECT AVG(velocidad_megas) velocidad_promedio
FROM Plan;

-- 4. Calcular el total de ingresos mensuales considerando todos los contratos activos
SELECT SUM(Plan.precio * (1 - Plan.descuento)) ingresos_mensuales
FROM Contrato INNER JOIN Plan ON Contrato.id_plan = Plan.id;

-- 5. Calcular el total de descuentos aplicados en todos los contratos
SELECT SUM(Plan.precio * Plan.descuento) AS total_descuentos
FROM Contrato INNER JOIN Plan ON Contrato.id_plan = Plan.id;

-- 6. Listar clientes que aún no han contratado un plan
SELECT Cliente.dni, Cliente.nombre, Cliente.apellido
FROM Cliente LEFT JOIN Contrato ON Cliente.dni = Contrato.dni_cliente
WHERE Contrato.dni_cliente IS NULL;

-- 7. Obtener el plan más caro y su velocidad correspondiente
SELECT id, velocidad_megas, precio
FROM Plan
ORDER BY precio DESC
LIMIT 1;

-- 8. Contar la cantidad de clientes por provincia
SELECT provincia, COUNT(*) AS cantidad_clientes
FROM Cliente
GROUP BY provincia;

-- 9. Obtener el cliente con el contrato más reciente y detalles del contrato
SELECT
	Cliente.dni,
    Cliente.nombre,
    Cliente.apellido,
    Contrato.id id_contrato,
    Plan.velocidad_megas,
    Plan.precio
FROM Cliente INNER JOIN Contrato ON Cliente.dni = Contrato.dni_cliente
INNER JOIN Plan ON Contrato.id_plan = Plan.id
ORDER BY Contrato.id DESC
LIMIT 1;

-- 10. Calcular el promedio de edad de los clientes
SELECT AVG(YEAR(CURDATE()) - YEAR(fecha_nacimiento)) edad_promedio
FROM Cliente;

