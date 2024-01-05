SELECT * 
FROM Contrato 
ORDER BY cliente_dni+0 ASC;

SELECT *
FROM Cliente
ORDER BY nombre DESC;

SELECT *
FROM Cliente
WHERE ciudad LIKE "Bogota";