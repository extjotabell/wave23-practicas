-- Creación de tablas
CREATE TABLE Cliente (
    dni INT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    provincia VARCHAR(255) NOT NULL,
    ciudad VARCHAR(255) NOT NULL
);

CREATE TABLE Plan (
    id INT PRIMARY KEY,
    velocidad_megas INT NOT NULL CHECK (velocidad_megas > 0),
    precio DECIMAL(10,2) NOT NULL CHECK (precio > 0),
    descuento DECIMAL(3,2) NOT NULL CHECK (descuento >= 0 AND descuento <= 1)
);

CREATE TABLE Contrato (
    id INT PRIMARY KEY,
    dni_cliente INT NOT NULL UNIQUE REFERENCES Cliente(dni),
    id_plan INT NOT NULL REFERENCES Plan(id)
);

-- Registros de prueba
INSERT INTO Cliente (dni, nombre, apellido, fecha_nacimiento, provincia, ciudad)
VALUES
  (1, 'Carlos', 'Gomez', '1992-08-15', 'Bogotá', 'Bogotá'),
  (2, 'Maria', 'Hernandez', '1985-05-20', 'Antioquia', 'Medellín'),
  (3, 'Andres', 'Martinez', '1990-12-03', 'Valle del Cauca', 'Cali'),
  (4, 'Laura', 'Lopez', '1988-02-10', 'Bolívar', 'Cartagena'),
  (5, 'Alejandro', 'Rodriguez', '1995-11-25', 'Atlántico', 'Barranquilla'),
  (6, 'Ana', 'Fernández', '1980-09-18', 'Cundinamarca', 'Soacha'),
  (7, 'Camila', 'Díaz', '1998-04-30', 'Bogotá', 'Bogotá'),
  (8, 'Santiago', 'Gutiérrez', '1993-07-22', 'Bogotá', 'Bogotá'),
  (9, 'Lucia', 'Alvarez', '1987-06-05', 'Antioquia', 'Medellín'),
  (10, 'Juan', 'Mendoza', '1994-12-12', 'Antioquia', 'Bello');

INSERT INTO Plan (id, velocidad_megas, precio, descuento)
VALUES
  (101, 100, 29.99, 0.1),
  (102, 50, 19.99, 0.05),
  (103, 200, 39.99, 0.2),
  (104, 75, 24.99, 0.15),
  (105, 150, 34.99, 0.12);

INSERT INTO Contrato (id, dni_cliente, id_plan)
VALUES
  (1, 1, 101),
  (2, 2, 102),
  (3, 3, 101),
  (4, 4, 103),
  (5, 5, 102),
  (6, 6, 104),
  (7, 7, 103),
  (8, 8, 105),
  (9, 9, 101),
  (10, 10, 102);