-- Registros de prueba
INSERT INTO Cliente (dni, nombre, apellido, nacimiento, provincia, ciudad)
VALUES
  (1, 'Manuel', 'Lopez', '1992-08-15', 'Bogotá', 'Bogotá'),
  (2, 'Lisandro', 'Martinez', '1985-05-20', 'Tlalpan', 'CDMX'),
  (3, 'Daniela', 'Cervantes', '1990-12-03', 'Texcoco', 'Edo Mex'),
  (4, 'Laura', 'Lopez', '1988-02-10', 'Bolívar', 'Cartagena'),
  (5, 'Luis', 'Perez', '1995-11-25', 'Atlántico', 'Barranquilla'),
  (6, 'Ana', 'Ramirez', '1980-09-18', 'Xalapa', 'Veracruz'),
  (7, 'Camila', 'Díaz', '1998-04-30', 'Bogotá', 'Bogotá'),
  (8, 'Santiago', 'Gutiérrez', '1993-07-22', 'Bogotá', 'Bogotá'),
  (9, 'Lucia', 'Alvarez', '1987-06-05', 'Antioquia', 'Medellín'),
  (10, 'Juan', 'Mendoza', '1994-12-12', 'Antioquia', 'Bello');

INSERT INTO Internet_plan (id, velocidad, precio, descuento)
VALUES
  (1, 100, 749.99, 0.1),
  (2, 50, 499.99, 0.05),
  (3, 200, 1399.99, 0.2),
  (4, 75, 599.99, 0.15),
  (5, 150, 999.99, 0.12);

INSERT INTO Contrato (id, cliente_dni, plan_id)
VALUES
  (1, 1, 1),
  (2, 2, 2),
  (3, 3, 1),
  (4, 4, 3),
  (5, 5, 2),
  (6, 6, 4),
  (7, 7, 3),
  (8, 7, 1),
  (9, 8, 5),
  (10, 10, 2);