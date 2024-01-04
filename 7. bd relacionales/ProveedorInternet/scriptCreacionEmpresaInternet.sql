-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS empresa_internet;

-- Seleccionar la base de datos
USE empresa_internet;

-- Creación de las tablas de la base de datos
CREATE TABLE clientes (
  dni INT PRIMARY KEY,
  nombre VARCHAR(255),
  apellido VARCHAR(255),
  fecha_nacimiento DATE,
  provincia VARCHAR(255),
  ciudad VARCHAR(255)
);

CREATE TABLE planes_internet (
  plan_id INT PRIMARY KEY,
  velocidad_megas INT,
  precio DECIMAL,
  descuento DECIMAL
);

CREATE TABLE contratos (
  contrato_id INT PRIMARY KEY,
  cliente_dni INT,
  plan_id INT,
  fecha_contrato DATE,
  FOREIGN KEY (cliente_dni) REFERENCES clientes(dni),
  FOREIGN KEY (plan_id) REFERENCES planes_internet(plan_id)
);

-- Inserción de registros en la tabla de clientes
INSERT INTO clientes (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
  (1, 'Juan', 'Perez', '1990-01-15', 'Buenos Aires', 'CABA'),
  (2, 'Ana', 'Gomez', '1985-05-20', 'Córdoba', 'Córdoba'),
  (3, 'Carlos', 'Rodriguez', '1992-08-10', 'Santa Fe', 'Rosario'),
  (4, 'Laura', 'Fernandez', '1980-03-25', 'Buenos Aires', 'La Plata'),
  (5, 'Pedro', 'Lopez', '1995-11-08', 'Mendoza', 'Mendoza'),
  (6, 'María', 'Diaz', '1982-06-18', 'Córdoba', 'Córdoba'),
  (7, 'Martín', 'Martinez', '1988-09-30', 'Buenos Aires', 'Quilmes'),
  (8, 'Sofía', 'Sanchez', '1993-12-05', 'Santa Fe', 'Santa Fe'),
  (9, 'Diego', 'Gonzalez', '1975-04-12', 'Mendoza', 'Godoy Cruz'),
  (10, 'Valeria', 'Luna', '1987-07-22', 'Córdoba', 'Río Cuarto');

-- Inserción de registros en la tabla de planes_internet
INSERT INTO planes_internet (plan_id, velocidad_megas, precio, descuento)
VALUES
  (1, 100, 50.99, 5),
  (2, 200, 75.50, 0),
  (3, 50, 30.25, 0),
  (4, 500, 100.75, 15),
  (5, 150, 45.90, 8);

-- Inserción de registros en la tabla de contratos
INSERT INTO contratos (contrato_id, cliente_dni, plan_id, fecha_contrato)
VALUES
  (1, 1, 2, '2023-02-10'),
  (2, 3, 4, '2023-03-15'),
  (3, 5, 1, '2023-04-20'),
  (4, 7, 3, '2023-05-25'),
  (5, 9, 5, '2023-06-30'),
  (6, 2, 1, '2023-07-05'),
  (7, 4, 2, '2023-08-10'),
  (8, 6, 3, '2023-09-15'),
  (9, 8, 4, '2023-10-20'),
  (10, 10, 5, '2023-11-25');
