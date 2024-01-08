-- Ejercicio 3
-- -----------------------------------------------------
-- Una vez realizado el planteo del diagrama y de haber respondido estas preguntas, utilizar PHPMyAdmin o MySQL Workbench para ejecutar lo siguiente:
-- a. Se solicita crear una nueva base de datos llamada “empresa_internet”.
-- c. Realizar las asociaciones/relaciones correspondientes entre estos registros. 
-- -----------------------------------------------------

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema internet_company
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema internet_company
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `internet_company` DEFAULT CHARACTER SET utf8 ;
USE `internet_company` ;

-- -----------------------------------------------------
-- Table `internet_company`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_company`.`clients` (
  `id` INT NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `birth_date` DATE NULL,
  `province` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_company`.`plans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_company`.`plans` (
  `id` INT NOT NULL,
  `speed` INT NOT NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `discount` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `internet_company`.`clients_plans`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `internet_company`.`clients_plans` (
  `clients_id` INT NOT NULL,
  `plans_id` INT NOT NULL,
  PRIMARY KEY (`clients_id`, `plans_id`),
  INDEX `fk_clients_has_plans_plans1_idx` (`plans_id` ASC),
  INDEX `fk_clients_has_plans_clients_idx` (`clients_id` ASC),
  CONSTRAINT `fk_clients_has_plans_clients`
    FOREIGN KEY (`clients_id`)
    REFERENCES `internet_company`.`clients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clients_has_plans_plans1`
    FOREIGN KEY (`plans_id`)
    REFERENCES `internet_company`.`plans` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

---------------------------
-- Ejercicio 2
-- A) La primary key de la tabla 'clients' es 'id' ya que debe corresponder a un único cliente y facilitar su identificación.
-- B) La primary key de la tabla 'plans' es 'id' ya que debe corresponder a un único plan de internet y facilitar su identificación.
/* C) Dado que pueden existir casos en que un cliente contrate varios planes distintos de un mismo proveedor y el proveedor pueda dar el mismo plan a distintos clientes,
      optamos por una relación muchos a muchos por lo que creamos una tabla intermedia llamada 'clients_plans' que contendrá las claves primarias de la tabla 'clients'
      y de 'plans' como foreign key. */
-- -----------------------------------------------------
-- Ejercicio 3
-- b. Incorporar 10 registros en la tabla de clientes y 5 en la tabla de planes de internet.
-- c. Realizar las asociaciones/relaciones correspondientes entre estos registros.
-- -----------------------------------------------------

INSERT INTO clients VALUES 
    (1, '12345678A', 'Juan', 'Pérez', '1990-05-15', 'Madrid', 'Madrid'),
    (2, '23456789B', 'María', 'Gómez', '1988-10-20', 'Barcelona', 'Barcelona'),
    (3, '34567890C', 'Pedro', 'López', '1995-03-08', 'Valencia', 'Valencia'),
    (4, '45678901D', 'Laura', 'Martínez', '1992-07-12', 'Sevilla', 'Sevilla'),
    (5, '56789012E', 'Carlos', 'Sánchez', '1987-12-28', 'Zaragoza', 'Zaragoza'),
    (6, '67890123F', 'Ana', 'Fernández', '1993-09-05', 'Málaga', 'Málaga'),
    (7, '78901234G', 'David', 'Ruiz', '1998-04-18', 'Madrid', 'Alicante'),
    (8, '89012345H', 'Elena', 'Díaz', '1991-06-25', 'Madrid', 'Murcia'),
    (9, '90123456I', 'Sergio', 'García', '1985-11-10', 'Bilbao', 'Bilbao'),
    (10, '01234567J', 'Carmen', 'Hernández', '1997-02-14', 'Valladolid', 'Valladolid');

INSERT INTO plans VALUES 
	(1, 300, 3000.0, 0.0),
	(2, 1000, 4000.0, 0.0),
	(3, 200, 2000.0, 0.0),
	(4, 200, 2000.0, 0.0),
	(5, 100, 1000.0, 1.0);

INSERT INTO clients_plans VALUES
	(1, 2),
	(1, 5),
	(4, 1),
	(8, 3);
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Ejercicio 4

-- 1. Mostrar todos los planes de internet
SELECT * FROM plans;

-- 2. Mostrar nombre y apellido de los clientes
SELECT  name, last_name 
FROM clients;

-- 3. Mostrar nombre y apellido de los clientes que sean de la provincia de Madrid
SELECT name, last_name 
FROM clients 
WHERE province = "Madrid";

-- 4. Mostrar  los clientes cuyo apellido sea 'Sergio'
SELECT * FROM clients 
WHERE name = 'Sergio';

-- 5. Mostrar velocidad, precio y descuento de los planes de internet
SELECT speed, price, discount 
FROM plans;

-- 6. Mostrar velocidad, precio y descuento de los planes de internet cuyo precio sea mayor a 1500 euros
SELECT speed, price, discount 
FROM plans 
WHERE price > 1500;

-- 7. Mostrar velocidad, precio y descuento de los planes de internet con descuento mayor a 0
SELECT speed, price, discount 
FROM plans 
WHERE discount > 0.0;

-- 8. Mostrar dni, nombre y provincia de los clientes que hayan nacido entre el año 1987 y el año 2002
SELECT dni, name, province
FROM clients 
WHERE birth_date >= '1987-01-01' AND '2002-12-31';

-- 9. Actualizar el nombre del cliente con id 1 'Juan' por 'Andres'
UPDATE clients
SET name = 'Andres'
WHERE id = 1;

-- 10. Actualizar la fecha de nacimiento de David Ruiz a la fecha '2000-05-23'
UPDATE clients 
SET birth_date = '2000-05-23'
WHERE id = 7;