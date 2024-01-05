# Práctica Individual Normalización

## Explicación

### Primera Forma Normal (1NF)

La tabla ya cumple con  1NF (Todos los valores en la tabla son atómicos)

### Segunda Forma Normal (2NF)

La 2NF requiere que una tabla no tenga dependencias funcionales parciales. Es decir, que cada atributo no clave de una tabla debe depender de la clave primaria.

Para cumplir con esto, dividimos la tabla en las siguientes partes: `cliente`, `articulo` y `factura`, cada una con la información correspondiente. Se ha de mencionar, que se consideró el IVA como un atributo independiente de cada artículo.

### Tercera Forma Normal (3NF)

Para cumplir con la tercera forma normal no deben haber atributos que dependan de otros atributos que no sean la clave primaria. En nuestro caso, ya no hay dependencias transitivas en las tablas `cliente`, `articulo` y `factura`.

Aún tenemos que resolver la relación de muchos a muchos entre facturas y artículos, entonces creamos una nueva tabla llamada `articulo_factura` que almacena la relación entre las facturas y los artículos. Utiliza claves foráneas para relacionar las tablas `factura` y `articulo` y almacena información específica de cada artículo en una factura, como `cantidad` e `importe`.

## Resultado final

![image](https://github.com/extjotabell/wave23-practicas/assets/45053254/c1b2ff70-a001-438d-ab79-cd2a0875fa6c)
