USE movies_db;

SELECT COUNT(*), mo.title, mo.rating, mo.awards
FROM movies mo 
JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY mo.title, mo.rating, mo.awards;

SELECT COUNT(*) as total, mo.title, mo.rating, mo.awards
FROM movies mo 
JOIN actors ac
ON mo.id = ac.favorite_movie_id
GROUP BY mo.title, mo.rating, mo.awards
HAVING total > 2;

SELECT dni, SUM(pago) as total
FROM clientes_pagos
WHERE pag > 50 -- Individual 
GROUP BY dni 
HAVING total > 100

-- Orden de ejecucion: WHERE -> Agregacion -> HAVING