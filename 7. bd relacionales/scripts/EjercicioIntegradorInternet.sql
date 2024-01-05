-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema empresa_internet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `empresa_internet` DEFAULT CHARACTER SET utf8 ;
USE `empresa_internet` ;

-- -----------------------------------------------------
-- Table `empresa_internet`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`clientes` (
  `id` INT NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `nacimiento` DATE NULL,
  `provincia` VARCHAR(45) NULL,
  `ciudad` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`planes` (
  `id` INT NOT NULL,
  `velocidad` INT NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `descuento` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `empresa_internet`.`clientes_planes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `empresa_internet`.`clientes_planes` (
  `clientes_id` INT NOT NULL,
  `planes_id` INT NOT NULL,
  PRIMARY KEY (`clientes_id`, `planes_id`),
  INDEX `fk_clientes_has_planes_planes1_idx` (`planes_id` ASC) VISIBLE,
  INDEX `fk_clientes_has_planes_clientes_idx` (`clientes_id` ASC) VISIBLE,
  CONSTRAINT `fk_clientes_has_planes_clientes`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `empresa_internet`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_has_planes_planes1`
    FOREIGN KEY (`planes_id`)
    REFERENCES `empresa_internet`.`planes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Ejercicio 2
-- A) La primary key de la tabla clientes es id ya que debe corresponder a un único cliente y facilitar su identificación.
-- B) La primary key de la tabla planes es id ya que debe corresponder a un único plan de internet y facilitar su identificación.
-- C) Dado que pueden existir casos en que un cliente contrate varios planes distintos de un mismo proveedor y el proveedor pueda dar el mismo plan a distintos clientes, optamos por una relación muchos a muchos por lo que creamos una tabla intermedia llamada ClientesPlanes que contendrá las claves primarias de la tabla Clientes y de Planes como foreign key.
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Ejercicio 3
INSERT INTO clientes VALUES
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

INSERT INTO planes VALUES
	(1, 50, 500.0, 0.0),
	(2, 100, 1000.0, 0.0),
	(3, 150, 2000.0, 0.0),
	(4, 200, 2500.0, 0.0),
	(5, 250, 3000.0, 1.0);


INSERT INTO clientes_planes VALUES
	(1, 2),
	(1, 5),
	(4, 1),
	(8, 3);
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Ejercicio 4
SELECT nombre, apellido FROM clientes;
SELECT nombre, apellido FROM clientes WHERE provincia = "Madrid";
SELECT velocidad, precio, descuento FROM planes;
SELECT velocidad, precio, descuento FROM planes WHERE precio > 1500;
SELECT velocidad, precio, descuento FROM planes WHERE descuento > 0.0;
SELECT id, velocidad,precio FROM planes order by velocidad desc;
SELECT velocidad, precio, descuento FROM planes WHERE descuento = 0.0;
SELECT DISTINCT COUNT(clientes_id) as planes_contratados_cliente_1 FROM clientes_planes WHERE clientes_id = 1;
SELECT nombre, apellido FROM clientes WHERE provincia = "Barcelona";
SELECT COUNT(id) as cantidad_usuarios FROM clientes;
-- -----------------------------------------------------
