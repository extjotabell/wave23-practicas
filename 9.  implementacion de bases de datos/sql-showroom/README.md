
# SQL Showroom

Ejercitación extra, práctica individual de implementación de bases de datos.

## Utilizando MySQL
En caso de utilizar MySQL ejecutar el siguiente [Script SQL](https://github.com/extjotabell/wave23-practicas/blob/leiva_florencia/9.%20%20implementacion%20de%20bases%20de%20datos/sql-showroom/src/main/resources/showroom.sql)

## Utilizando H2
### Preparación de la Tabla Sizes

Antes de realizar cualquier inserción de datos en la aplicación, es necesario insertar los siguientes datos en la tabla "sizes".

### Instrucciones:
Abre tu herramienta de administración de base de datos preferida.

Ejecuta el siguiente script SQL para insertar los talles en la tabla `sizes`:

```SQL
INSERT INTO sizes (id, name) VALUES
  (1, 'Small'),
  (2, 'Medium'),
  (3, 'Large'),
  (4, 'Extra Large');
```
Estos datos representan tamaños comunes y proporcionarán valores predefinidos para la columna `name`.