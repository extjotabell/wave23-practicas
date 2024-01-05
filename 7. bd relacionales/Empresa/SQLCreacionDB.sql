-- Crear la tabla DEPARTAMENTO
CREATE TABLE DEPARTAMENTO (
    depto_nro VARCHAR(10) PRIMARY KEY,
    nombre_depto VARCHAR(50),
    localidad VARCHAR(50)
);

-- Insertar datos en la tabla DEPARTAMENTO
INSERT INTO DEPARTAMENTO VALUES ('D-000-1', 'Software', 'Los Tigres');
INSERT INTO DEPARTAMENTO VALUES ('D-000-2', 'Sistemas', 'Guadalupe');
INSERT INTO DEPARTAMENTO VALUES ('D-000-3', 'Contabilidad', 'La Roca');
INSERT INTO DEPARTAMENTO VALUES ('D-000-4', 'Ventas', 'Plata');

-- Crear la tabla EMPLEADO con la clave foránea
CREATE TABLE EMPLEADO (
    cod_emp VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    puesto VARCHAR(50),
    fecha_alta DATE,
    salario DECIMAL(10, 2),
    comision DECIMAL(10, 2),
    depto_nro VARCHAR(10),
    FOREIGN KEY (depto_nro) REFERENCES DEPARTAMENTO(depto_nro)
);

-- Insertar datos en la tabla EMPLEADO
INSERT INTO EMPLEADO VALUES ('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4');
INSERT INTO EMPLEADO VALUES ('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2');
INSERT INTO EMPLEADO VALUES ('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3');
INSERT INTO EMPLEADO VALUES ('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4');
INSERT INTO EMPLEADO VALUES ('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4');
INSERT INTO EMPLEADO VALUES ('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3');
INSERT INTO EMPLEADO VALUES ('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');
