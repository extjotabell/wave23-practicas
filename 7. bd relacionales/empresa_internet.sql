-- MySQL dump 10.13  Distrib 8.0.34, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: empresa_internet
-- ------------------------------------------------------
-- Server version	8.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `dni_cliente` varchar(8) NOT NULL,
  `nombre_cliente` varchar(50) NOT NULL,
  `apellido_cliente` varchar(50) NOT NULL,
  `fecha_nacimiento_cliente` datetime NOT NULL,
  `provincia_cliente` varchar(50) NOT NULL,
  `ciudad_cliente` varchar(50) NOT NULL,
  `identificacion_plan_internet` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`dni_cliente`),
  KEY `identificacion_plan_internet_idx` (`identificacion_plan_internet`),
  CONSTRAINT `identificacion_plan_internet` FOREIGN KEY (`identificacion_plan_internet`) REFERENCES `planes_internet` (`identificacion_plan_internet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('12345669','LAURA','MAYA','2002-05-03 00:00:00','CAPITAL FEDERAL','CABA','PLAN FLASH'),('12345670','LEONARDO','ROJAS','1966-05-03 00:00:00','CAPITAL FEDERAL','CABA','PLAN FAMILIAR'),('12345671','GABRIEL','GUTIERREZ','1999-05-15 00:00:00','CAPITAL FEDERAL','CABA','PLAN FLASH'),('12345672','LARA','GALAN','1995-05-25 00:00:00','BUENOS AIRES','EL PALOMAR','PLAN ULTRA'),('12345673','CAROLINA','BUSTAMANTE','1999-10-25 00:00:00','BUENOS AIRES','MUNRO','PLAN MEGA OFF'),('12345674','ROBERTO','GOMEZ','1970-06-07 00:00:00','CAPITAL FEDERAL','CABA','PLAN ULTRA'),('12345675','LUISA','QUIÑONES','1999-10-07 00:00:00','CORDOBA','VILLA CARLOS PAZ','PLAN FLASH'),('12345676','JOSE','FLORES','1997-09-04 00:00:00','CORDOBA','CORDOBA','PLAN FAMILIAR'),('12345677','MARIA','RODRIGUEZ','1995-06-04 00:00:00','BUENOS AIRES','VICENTE LOPEZ','PLAN MEGA'),('12345678','LUIS','PEREZ','1990-01-04 00:00:00','BUENOS AIRES','BURZACO','PLAN MEGA OFF');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes_internet`
--

DROP TABLE IF EXISTS `planes_internet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes_internet` (
  `identificacion_plan_internet` varchar(20) NOT NULL,
  `velocidad_en_mb_plan_internet` int NOT NULL,
  `precio_plan_internet` float NOT NULL,
  `descuento_plan_internet` float NOT NULL,
  PRIMARY KEY (`identificacion_plan_internet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes_internet`
--

LOCK TABLES `planes_internet` WRITE;
/*!40000 ALTER TABLE `planes_internet` DISABLE KEYS */;
INSERT INTO `planes_internet` VALUES ('PLAN FAMILIAR',5000,50000,10000),('PLAN FLASH',1000,15000,0),('PLAN MEGA',2000,30000,0),('PLAN MEGA OFF',2000,30000,10000),('PLAN ULTRA',3000,40000,0);
/*!40000 ALTER TABLE `planes_internet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-04 20:14:41
