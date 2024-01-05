
CREATE SCHEMA `empresa_internet` DEFAULT CHARACTER SET utf8 ;

--
-- Table structure for table `planes`
--
DROP TABLE IF EXISTS `planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes` (
  `idPlan` int NOT NULL,
  `velocity` int NOT NULL,
  `price` float NOT NULL,
  `discount` float NOT NULL,
  PRIMARY KEY (`idPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
LOCK TABLES `planes` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--
DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idCliente` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `dni` int NOT NULL,
  `birthdate` datetime NOT NULL,
  `province` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `FKidPlan` int NOT NULL,
  PRIMARY KEY (`idCliente`),
  KEY `FKidPlan_idx` (`FKidPlan`),
  CONSTRAINT `FKidPlan` FOREIGN KEY (`FKidPlan`) REFERENCES `planes` (`idPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

LOCK TABLES `cliente` WRITE;
UNLOCK TABLES;