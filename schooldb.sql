-- MySQL dump 10.13  Distrib 8.0.33, for macos12.6 (arm64)
--
-- Host: localhost    Database: schooldb
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `ClientModel`
--

DROP TABLE IF EXISTS `ClientModel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ClientModel` (
  `clientID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ClientModel`
--

LOCK TABLES `ClientModel` WRITE;
/*!40000 ALTER TABLE `ClientModel` DISABLE KEYS */;
INSERT INTO `ClientModel` VALUES (2,'Adi','adi@tanasa','Cluj!!!'),(3,'te','te','tes');
/*!40000 ALTER TABLE `ClientModel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `OrderModel`
--

DROP TABLE IF EXISTS `OrderModel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `OrderModel` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `productID` int NOT NULL,
  `clientID` int NOT NULL,
  `productQuantity` int NOT NULL,
  PRIMARY KEY (`orderID`),
  KEY `productID` (`productID`),
  KEY `clientID` (`clientID`),
  CONSTRAINT `ordermodel_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `ProductModel` (`productID`),
  CONSTRAINT `ordermodel_ibfk_2` FOREIGN KEY (`clientID`) REFERENCES `ClientModel` (`clientID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `OrderModel`
--

LOCK TABLES `OrderModel` WRITE;
/*!40000 ALTER TABLE `OrderModel` DISABLE KEYS */;
INSERT INTO `OrderModel` VALUES (1,4,3,0);
/*!40000 ALTER TABLE `OrderModel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productModel`
--

DROP TABLE IF EXISTS `productModel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productModel` (
  `productID` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productModel`
--

LOCK TABLES `productModel` WRITE;
/*!40000 ALTER TABLE `productModel` DISABLE KEYS */;
INSERT INTO `productModel` VALUES (2,'An orange',15,'a beautiful orang!!!!e',0),(3,'Baguette',20,'o bagheta',0),(4,'test',12,'test',0),(5,'Shop',15,'shp ala blanano',0);
/*!40000 ALTER TABLE `productModel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-22 22:13:05
