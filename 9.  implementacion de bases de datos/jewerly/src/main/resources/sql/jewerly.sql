-- DROP DATABASE jewerly;
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema jewerly
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jewerly
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jewerly` DEFAULT CHARACTER SET utf8 ;
USE `jewerly` ;

-- -----------------------------------------------------
-- Table `jewerly`.`jewel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jewerly`.`jewel` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `material` VARCHAR(45) NULL,
  `weight` DECIMAL(10,2) NULL,
  `particularity` VARCHAR(45) NULL,
  `have_stone` TINYINT NOT NULL,
  `sell_or_no` TINYINT(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

SELECT * FROM jewel;