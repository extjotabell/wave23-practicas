-- MySQL Workbench Forward Engineering
-- DROP DATABASE auto_insurance;

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema auto_insurance
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema auto_insurance
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `auto_insurance` DEFAULT CHARACTER SET utf8 ;
USE `auto_insurance` ;

CREATE TABLE IF NOT EXISTS vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    patent_vehicles VARCHAR(255) NOT NULL,
    brand_vehicles VARCHAR(255) NOT NULL,
    model_vehicles VARCHAR(255) NOT NULL,
    year_build_vehicles INT NOT NULL,
    quantity_wheels_vehicles INT NOT NULL
);

CREATE TABLE IF NOT EXISTS accidents (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accident_date DATE NOT NULL,
    economic_loss DOUBLE NOT NULL,
    vehicle_id INT,
    FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO vehicles (patent_vehicles, brand_vehicles, model_vehicles, year_build_vehicles, quantity_wheels_vehicles)
VALUES 
('ABC123', 'Toyota', 'Corolla', 2024, 4),
('DEF456', 'Honda', 'Civic', 2012, 4),
('GHI789', 'Ford', 'Fiesta', 2015, 5),
('JKL012', 'Chevrolet', 'Cruze', 2022, 4),
('MNO345', 'Nissan', 'Sentra', 2011, 4),
('PQR678', 'Hyundai', 'Elantra', 2013, 4),
('STU901', 'Volkswagen', 'Golf', 2023, 5),
('VWX234', 'Subaru', 'Impreza', 2016, 4),
('YZA567', 'Mazda', '3', 2017, 4),
('BCD890', 'Kia', 'Forte', 2019, 4);

INSERT INTO accidents (accident_date, economic_loss, vehicle_id)
VALUES 
('2022-01-01', 5000.00, 1),
('2022-02-01', 6000.00, 3),
('2022-03-01', 7000.00, 3),
('2022-04-01', 8000.00, 1),
('2022-05-01', 9000.00, 5),
('2022-06-01', 10000.00, 10),
('2022-07-01', 11000.00, 7),
('2022-08-01', 12000.00, 6),
('2022-09-01', 13000.00, 9),
('2022-10-01', 14000.00, 10);
