-- Crear el esquema
CREATE SCHEMA company;
-- Usar el esquema
USE company;
-- Crear la tabla departamento
CREATE TABLE departments (
    id_departments VARCHAR(10) PRIMARY KEY,
    name_departments VARCHAR(50),
    location_departments VARCHAR(50)
);
-- Crear la tabla empleado
CREATE TABLE employees (
    id_employees VARCHAR(10) PRIMARY KEY,
    name_employees VARCHAR(50),
    last_name_employees VARCHAR(50),
    role_employees VARCHAR(50),
    hiring_date_employees DATE,
    salary_employees INT,
    commission_employees INT,
    id_departments VARCHAR(10),
    FOREIGN KEY (id_departments) REFERENCES departments(id_departments)
);
-- Insertar datos en la tabla departamento
INSERT INTO departments VALUES
('D-000-1', 'Software', 'Los Tigres'),
('D-000-2', 'Sistemas', 'Guadalupe'),
('D-000-3', 'Contabilidad', 'La Roca'),
('D-000-4', 'Ventas', 'Plata');
-- Insertar datos en la tabla empleado
INSERT INTO employees VALUES
('E-0001', 'César', 'Piñero', 'Vendedor', '2018-05-12', 80000, 15000, 'D-000-4'),
('E-0002', 'Yosep', 'Kowaleski', 'Analista', '2015-07-14', 140000, 0, 'D-000-2'),
('E-0003', 'Mariela', 'Barrios', 'Director', '2014-06-05', 185000, 0, 'D-000-3'),
('E-0004', 'Jonathan', 'Aguilera', 'Vendedor', '2015-06-03', 85000, 10000, 'D-000-4'),
('E-0005', 'Daniel', 'Brezezicki', 'Vendedor', '2018-03-03', 83000, 10000, 'D-000-4'),
('E-0006', 'Mito', 'Barchuk', 'Presidente', '2014-06-05', 190000, 0, 'D-000-3'),
('E-0007', 'Emilio', 'Galarza', 'Desarrollador', '2014-08-02', 60000, 0, 'D-000-1');

-- 1. Seleccionar el nombre, el puesto y la localidad de los departamentos donde trabajan los vendedores.

SELECT employees.name_employees, employees.last_name_employees, departments.location_departments
FROM employees
INNER JOIN departments 
ON departments.id_departments = employees.id_departments;

-- 2. Visualizar los departamentos con más de cinco empleados.
SELECT departments.*, COUNT(employees.id_departments) AS total_employees
FROM departments
INNER JOIN employees
ON employees.id_departments = departments.id_departments
GROUP BY departments.id_departments
HAVING COUNT(employees.id_employees) > 5;

-- 3. Mostrar el nombre, salario y nombre del departamento de los empleados que tengan el mismo puesto que ‘Mito Barchuk’.
SELECT e.name_employees, e.salary_employees, d.name_departments
FROM employees AS e
INNER JOIN departments AS d
ON d.id_departments = e.id_departments
WHERE e.role_employees = (
	SELECT role_employees 
    FROM employees 
    WHERE name_employees = 'Mito' 
    AND last_name_employees = 'Barchuk' 
);

-- 4. Mostrar los datos de los empleados que trabajan en el departamento de contabilidad, ordenados por nombre.
SELECT employees.* 
FROM employees
INNER JOIN departments
ON departments.id_departments = employees.id_departments
WHERE departments.name_departments = 'Contabilidad';

-- 5. Mostrar el nombre del empleado que tiene el salario más bajo.
SELECT employees.name_employees 
FROM employees
ORDER BY salary_employees ASC
LIMIT 1;

-- 6. Mostrar los datos del empleado que tiene el salario más alto en el departamento de ‘Ventas’.
SELECT employees.*
FROM employees
INNER JOIN departments
ON departments.id_departments = employees.id_departments
WHERE departments.name_departments = 'Ventas'
ORDER BY employees.salary_employees DESC
LIMIT 1;

