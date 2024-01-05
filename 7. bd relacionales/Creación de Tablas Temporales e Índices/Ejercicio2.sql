-- Ejercicio 2

CREATE INDEX idx_favorite_movie_id ON actors(favorite_movie_id);

SHOW INDEX FROM actors;

/*
La decisión de crear un índice en la columna favorite_movie_id se basa en la posibilidad de búsquedas o uniones frecuentes que involucren esta columna. Los índices ayudan a acelerar la velocidad de recuperación de datos al proporcionar una estructura optimizada para la búsqueda.
En este caso, si se espera que haya consultas o uniones frecuentes basadas en la columna favorite_movie_id, agregar un índice puede mejorar significativamente el rendimiento de esas consultas. El índice ordenará y organizará los datos en función de los valores de la columna favorite_movie_id, lo que facilitará y acelerará las operaciones de búsqueda o unión que involucren esta columna.
*/
