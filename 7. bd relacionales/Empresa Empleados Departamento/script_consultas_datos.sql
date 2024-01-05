-- Creamos DB
CREATE SCHEMA `empresa_depto_empl`;

-- Creamos tablas
CREATE TABLE `departamentos` (
  `depto_nro` varchar(255) PRIMARY KEY,
  `nombre_depto` varchar(255),
  `localidad` varchar(255)
);

CREATE TABLE `empleados` (
  `cod_emp` varchar(255) PRIMARY KEY,
  `nombre` varchar(255),
  `apellido` varchar(255),
  `puesto` varchar(255),
  `fecha_alta` date,
  `salario` double,
  `comision` Integer,
  `depto_nro` varchar(255),
  CONSTRAINT `fk_depto_nro` FOREIGN KEY (`depto_nro`) REFERENCES `departamentos` (`depto_nro`)
);


-- Insertamos registros:
INSERT INTO departamentos VALUES
("D-000-1", "Software", "Los Tigres"),
("D-000-2", "Sistemas", "Guadalupe"),
("D-000-3", "Contabilidad", "La Roca"),
("D-000-4", "Ventas", "Plata");

INSERT INTO empleados VALUES
("E-0001", "César", "Piñero", "Vendedor", STR_TO_DATE('12/05/2018', '%d/%m/%Y'), 80000, 15000, "D-000-4"),
("E-0002", "Yosep", "Kowaleski", "Analista", STR_TO_DATE('14/07/2015', '%d/%m/%Y'), 140000, 0, "D-000-2"),
("E-0003", "Mariela", "Barrios", "Director", STR_TO_DATE('05/06/2014', '%d/%m/%Y'), 185000, 0, "D-000-3"),
("E-0004", "Jonathan", "Aguilera", "Vendedor", STR_TO_DATE('03/06/2015', '%d/%m/%Y'), 85000, 10000, "D-000-4"),
("E-0005", "Daniel", "Brezezicki", "Vendedor", STR_TO_DATE('03/03/2018', '%d/%m/%Y'), 83000, 10000, "D-000-4"),
("E-0006", "Mito", "Barchuk", "Presidente", STR_TO_DATE('05/06/2014', '%d/%m/%Y'), 190000, 0, "D-000-3"),
("E-0007", "Emilio", "Galarza", "Desarrollador", STR_TO_DATE('02/08/2014', '%d/%m/%Y'), 60000, 0, "D-000-1");