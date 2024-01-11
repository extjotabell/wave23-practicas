-- DROP DATABASE jpacrud;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jpacrud
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jpacrud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jpacrud` DEFAULT CHARACTER SET utf8 ;
USE `jpacrud` ;

-- -----------------------------------------------------
-- Table `jpacrud`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jpacrud`.`student` (
  `id` bigint NOT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT * FROM student;
