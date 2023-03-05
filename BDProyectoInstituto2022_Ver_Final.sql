CREATE DATABASE  IF NOT EXISTS `proyectoinstituto2022` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `proyectoinstituto2022`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectoinstituto2022
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `acceso`
--

DROP TABLE IF EXISTS `acceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acceso` (
  `codMenu` int NOT NULL,
  `idUsuario` int NOT NULL,
  PRIMARY KEY (`codMenu`,`idUsuario`),
  KEY `idUsuario` (`idUsuario`),
  CONSTRAINT `acceso_ibfk_1` FOREIGN KEY (`codMenu`) REFERENCES `menu` (`codMenu`),
  CONSTRAINT `acceso_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acceso`
--

LOCK TABLES `acceso` WRITE;
/*!40000 ALTER TABLE `acceso` DISABLE KEYS */;
INSERT INTO `acceso` VALUES (4,1),(5,1),(6,1),(1,2),(2,2),(3,2);
/*!40000 ALTER TABLE `acceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `DNI` char(8) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nac` date NOT NULL,
  `correo` varchar(50) NOT NULL,
  `cod_Distrito` int NOT NULL,
  `cod_Pais` int NOT NULL,
  `direccion` varchar(50) NOT NULL,
  PRIMARY KEY (`DNI`),
  KEY `cod_Distrito` (`cod_Distrito`),
  KEY `cod_Pais` (`cod_Pais`),
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`cod_Distrito`) REFERENCES `distrito` (`codDistrito`),
  CONSTRAINT `alumno_ibfk_2` FOREIGN KEY (`cod_Pais`) REFERENCES `pais` (`codPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES ('12345678','ddddd','dsssss','1998-11-14','ss@fff',1,1,'av mamama'),('46286106','Carlos','Arnao','1980-02-15','colosus345@hotmail.com',3,1,'Av Izaguirre 125'),('70477605','Juan','Perez','2022-01-02','juan@gmail.com',1,1,'Av 28 julio 22');
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carrera`
--

DROP TABLE IF EXISTS `carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carrera` (
  `idCarrera` int NOT NULL AUTO_INCREMENT,
  `nom_Carrera` varchar(50) NOT NULL,
  `codfacultad` int NOT NULL,
  `ciclo` varchar(50) NOT NULL,
  `creditos` int NOT NULL,
  PRIMARY KEY (`idCarrera`),
  KEY `codfacultad` (`codfacultad`),
  CONSTRAINT `carrera_ibfk_1` FOREIGN KEY (`codfacultad`) REFERENCES `facultad` (`codFacultad`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrera`
--

LOCK TABLES `carrera` WRITE;
/*!40000 ALTER TABLE `carrera` DISABLE KEYS */;
INSERT INTO `carrera` VALUES (1,'Redes y Comunicaciones',1,'VI CICLOS',138),(2,'Industrial y Sistemas',1,'VI CICLOS',138),(3,'Computación e Informática',1,'VI CICLOS',138),(4,'Comunicacion y Arte Digital',2,'VI CICLOS',138),(5,'Publicidad y Branding',2,'VI CICLOS',138),(6,'Traduccion e Interpretacion',2,'VI CICLOS',138),(7,'Diseño Gráfico',3,'VI CICLOS',138),(8,'Animacion Digital',3,'VI CICLOS',138),(9,'Diseño de Interiores',3,'VI CICLOS',138);
/*!40000 ALTER TABLE `carrera` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comprobante_pago`
--

DROP TABLE IF EXISTS `comprobante_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comprobante_pago` (
  `idComPago` varchar(10) NOT NULL,
  `fecha_com` date NOT NULL,
  `monto` decimal(10,0) NOT NULL,
  `idInscripcion` varchar(20) NOT NULL,
  `Estado` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idComPago`),
  KEY `idInscripcion` (`idInscripcion`),
  CONSTRAINT `comprobante_pago_ibfk_1` FOREIGN KEY (`idInscripcion`) REFERENCES `inscripcion` (`idInscripcion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comprobante_pago`
--

LOCK TABLES `comprobante_pago` WRITE;
/*!40000 ALTER TABLE `comprobante_pago` DISABLE KEYS */;
INSERT INTO `comprobante_pago` VALUES ('OP-0001','2022-11-21',150,'RE-0002','GENERADO');
/*!40000 ALTER TABLE `comprobante_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distrito`
--

DROP TABLE IF EXISTS `distrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distrito` (
  `codDistrito` int NOT NULL,
  `nomDistrito` varchar(50) NOT NULL,
  PRIMARY KEY (`codDistrito`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distrito`
--

LOCK TABLES `distrito` WRITE;
/*!40000 ALTER TABLE `distrito` DISABLE KEYS */;
INSERT INTO `distrito` VALUES (1,'comas'),(2,'Los Olivos'),(3,'Independencia'),(4,'Breña');
/*!40000 ALTER TABLE `distrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facultad`
--

DROP TABLE IF EXISTS `facultad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facultad` (
  `codFacultad` int NOT NULL,
  `nomFacultad` varchar(50) NOT NULL,
  PRIMARY KEY (`codFacultad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facultad`
--

LOCK TABLES `facultad` WRITE;
/*!40000 ALTER TABLE `facultad` DISABLE KEYS */;
INSERT INTO `facultad` VALUES (1,'Tecnologías de la Información'),(2,'Comunicaciones'),(3,'Diseño'),(4,'Ingeniería'),(5,'Gestión de negocios');
/*!40000 ALTER TABLE `facultad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripcion`
--

DROP TABLE IF EXISTS `inscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inscripcion` (
  `idInscripcion` varchar(20) NOT NULL,
  `id_Carrera` int NOT NULL,
  `DNI` char(8) NOT NULL,
  `fec_Inscripcion` date NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idInscripcion`),
  KEY `DNI` (`DNI`),
  KEY `id_Carrera` (`id_Carrera`),
  CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `alumno` (`DNI`),
  CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`id_Carrera`) REFERENCES `carrera` (`idCarrera`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripcion`
--

LOCK TABLES `inscripcion` WRITE;
/*!40000 ALTER TABLE `inscripcion` DISABLE KEYS */;
INSERT INTO `inscripcion` VALUES ('RE-0001',6,'12345678','2022-11-14','PENDIENTE DE PAGO'),('RE-0002',8,'70477605','2022-11-21','PENDIENTE DE PAGO'),('RE-0003',7,'46286106','2022-11-21','GENERADO');
/*!40000 ALTER TABLE `inscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `menu` (
  `codMenu` int NOT NULL,
  `descrip_menu` varchar(50) NOT NULL,
  `url` varchar(35) NOT NULL,
  PRIMARY KEY (`codMenu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Alumno','MantenimientoAlumno.jsp'),(2,'Ficha Inscripcion','FichaInscripcion.jsp'),(3,'Orden Pago','Inscripciones.jsp'),(4,'Carreras','carrera.jsp'),(5,'Modificar Ficha Inscripcion','Inscripciones.jsp'),(6,'Reportes','reportes.jsp');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pais` (
  `codPais` int NOT NULL,
  `nomPais` varchar(50) NOT NULL,
  PRIMARY KEY (`codPais`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'Perú'),(2,'Argentina'),(3,'Chile'),(5,'Colombia'),(6,'Paraguay');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `idRol` int NOT NULL,
  `nomRol` varchar(40) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Secretaria'),(2,'Administrador');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `DNI` char(8) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `nombreUsuario` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `idRol` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `sd_idx` (`idRol`),
  CONSTRAINT `FK_Roles` FOREIGN KEY (`idRol`) REFERENCES `roles` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'70477605','Sebastian ','Seb123','Seb123',2),(2,'15426983','Maria','Maria123','Maria123',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'proyectoinstituto2022'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_generar_numero` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generar_numero`()
BEGIN
declare num int;
set num=(select count(idInscripcion)from inscripcion);
if(num=0) then
select'RE-0001';
else
select concat('RE-',right(concat('0000',cast(right(max(idInscripcion),4)as SIGNED)+1),4))
from inscripcion;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_generar_Pago` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generar_Pago`()
BEGIN
declare num int;
set num=(select count(idComPago)from comprobante_pago);
if(num=0) then
select'OP-0001';
else
select concat('OP-',right(concat('0000',cast(right(max(idComPago),4)as SIGNED)+1),4))
from comprobante_pago;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-21 18:33:38
