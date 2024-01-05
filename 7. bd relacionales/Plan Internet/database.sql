DROP DATABASE IF EXISTS internet_db;
CREATE DATABASE internet_db; 

DROP TABLE IF EXISTS `Contrato`;
CREATE TABLE `Contrato` (
  `id` varchar(255) PRIMARY KEY,
  `cliente_dni` varchar(255) ,
  `plan_id` integer
);

DROP TABLE IF EXISTS `Cliente`;
CREATE TABLE `Cliente` (
  `dni` varchar(255) PRIMARY KEY,
  `nombre` varchar(255),
  `apellido` varchar(255),
  `nacimiento` timestamp,
  `provincia` varchar(255),
  `ciudad` varchar(255)
);
DROP TABLE IF EXISTS `Internet_plan`;
CREATE TABLE `Internet_plan` (
  `id` integer PRIMARY KEY,
  `nombre_plan` varchar(255),
  `velocidad` integer,
  `precio` decimal,
  `descuento` decimal
);

ALTER TABLE `Contrato` ADD FOREIGN KEY (`cliente_dni`) REFERENCES `Cliente` (`dni`);

ALTER TABLE `Contrato` ADD FOREIGN KEY (`plan_id`) REFERENCES `Internet_plan` (`id`);
