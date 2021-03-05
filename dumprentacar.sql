-- MySQL dump 10.13  Distrib 8.0.23, for Linux (x86_64)
--
-- Host: localhost    Database: rentacar
-- ------------------------------------------------------
-- Server version	8.0.23-0ubuntu0.20.04.1

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
-- Table structure for table `automovil`
--

DROP TABLE IF EXISTS `automovil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automovil` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cap_maleta` float DEFAULT NULL,
  `cap_pasajeros` int DEFAULT NULL,
  `cap_toneladas` float DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `num_ejes` int DEFAULT NULL,
  `num_puertas` int DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automovil`
--

LOCK TABLES `automovil` WRITE;
/*!40000 ALTER TABLE `automovil` DISABLE KEYS */;
/*!40000 ALTER TABLE `automovil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `automoviles`
--

DROP TABLE IF EXISTS `automoviles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `automoviles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cap_maleta` float DEFAULT NULL,
  `cap_pasajeros` int DEFAULT NULL,
  `cap_toneladas` float DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `num_ejes` int DEFAULT NULL,
  `num_puertas` int DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `automoviles`
--

LOCK TABLES `automoviles` WRITE;
/*!40000 ALTER TABLE `automoviles` DISABLE KEYS */;
INSERT INTO `automoviles` VALUES (1,NULL,NULL,NULL,'2021-03-05 13:22:10.642000',NULL,NULL,'sedan',NULL),(2,NULL,NULL,NULL,'2021-03-05 13:22:56.837000',NULL,NULL,'hatchback',NULL),(3,20,5,NULL,NULL,NULL,5,'citycar',NULL),(4,100,5,NULL,NULL,NULL,5,'SUV',NULL),(5,30,5,NULL,NULL,NULL,3,'deportivo',NULL),(6,NULL,NULL,100,NULL,5,NULL,'cisterna',NULL),(7,NULL,NULL,150,NULL,6,NULL,'portacoches',NULL),(8,NULL,NULL,1000,NULL,10,NULL,'contenedor',NULL);
/*!40000 ALTER TABLE `automoviles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mantenciones`
--

DROP TABLE IF EXISTS `mantenciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantenciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_mantencion` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `id_vehiculo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl7l7cp6xalbcgupci6ra2el9t` (`id_vehiculo`),
  CONSTRAINT `FK35397poqbiomhh0xh5dk7x104` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id`),
  CONSTRAINT `FKl7l7cp6xalbcgupci6ra2el9t` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mantenciones`
--

LOCK TABLES `mantenciones` WRITE;
/*!40000 ALTER TABLE `mantenciones` DISABLE KEYS */;
INSERT INTO `mantenciones` VALUES (15,NULL,'cambio aceite',NULL,NULL,150000,2),(17,NULL,'cambio líquido de freno',NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `mantenciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `anio` int DEFAULT NULL,
  `cilindrada` float DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `kilometros` float DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `patente` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `id_automovil` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9xvncdn0q52d87sf07jar7qp3` (`id_automovil`),
  CONSTRAINT `FK9xvncdn0q52d87sf07jar7qp3` FOREIGN KEY (`id_automovil`) REFERENCES `automovil` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculos`
--

DROP TABLE IF EXISTS `vehiculos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `anio` int DEFAULT NULL,
  `cilindrada` float DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `kilometros` float DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `patente` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `id_automovil` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlq633unx2k0w2akcokujhr1pn` (`id_automovil`),
  CONSTRAINT `FKlq633unx2k0w2akcokujhr1pn` FOREIGN KEY (`id_automovil`) REFERENCES `automoviles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculos`
--

LOCK TABLES `vehiculos` WRITE;
/*!40000 ALTER TABLE `vehiculos` DISABLE KEYS */;
INSERT INTO `vehiculos` VALUES (1,NULL,NULL,'2021-03-05 13:22:13.363000',1000000,'Nissan','Stanza','AJ6338',NULL,1),(2,NULL,NULL,'2021-03-05 13:22:57.066000',17,'Suzuki','Swift','PLFB94',NULL,2),(3,2006,1000,NULL,130000,'Chevrolet','Spark','ZS7327',NULL,3),(4,2006,2500,NULL,130000,'Mazda','5','WE9357',NULL,4),(5,1995,1500,NULL,200000,'Honda','Integra','LB5093',NULL,5),(6,2010,1300,NULL,190000,'Volvo','Olx','GRLS23',NULL,6);
/*!40000 ALTER TABLE `vehiculos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-05 15:33:57
