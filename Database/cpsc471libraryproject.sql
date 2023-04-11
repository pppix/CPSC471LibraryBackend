-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: cpsc471libraryproject
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `admin`
--
DROP DATABASE IF EXISTS `cpsc471libraryproject`;
CREATE DATABASE `cpsc471libraryproject`;
USE `cpsc471libraryproject`;

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `ID` int NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `ID` FOREIGN KEY (`ID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `book` (
  `ProductID` int NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `BookAdminID` int NOT NULL,
  `Genre` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `Count` int NOT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `BookAdminID_idx` (`BookAdminID`),
  CONSTRAINT `BookAdminID` FOREIGN KEY (`BookAdminID`) REFERENCES `admin` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'To Kill a Mockingbird','Available',1,'Bildungsroman','Harper Lee',1);
INSERT INTO `book` VALUES (2,'1984','Available',1,'Dystopian Fiction','George Orwell',1);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checked_out_books`
--

DROP TABLE IF EXISTS `checked_out_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checked_out_books` (
  `BookID` int NOT NULL,
  `BookCID` int NOT NULL,
  `DueDate` varchar(45) NOT NULL,
  `BorrowDate` varchar(45) NOT NULL,
  `OverDueFee` varchar(45) NOT NULL,
  PRIMARY KEY (`BookID`,`BookCID`),
  KEY `BookCID_idx` (`BookCID`),
  CONSTRAINT `BookCID` FOREIGN KEY (`BookCID`) REFERENCES `customer` (`CustID`),
  CONSTRAINT `BookID` FOREIGN KEY (`BookID`) REFERENCES `book` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checked_out_books`
--

LOCK TABLES `checked_out_books` WRITE;
/*!40000 ALTER TABLE `checked_out_books` DISABLE KEYS */;
/*!40000 ALTER TABLE `checked_out_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checked_out_journals`
--

DROP TABLE IF EXISTS `checked_out_journals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checked_out_journals` (
  `JournalID` int NOT NULL,
  `JournalCID` int NOT NULL,
  `DueDate` varchar(45) NOT NULL,
  `BorrowDate` varchar(45) NOT NULL,
  `OverDueFee` varchar(45) NOT NULL,
  PRIMARY KEY (`JournalID`,`JournalCID`),
  KEY `JournalCID_idx` (`JournalCID`),
  CONSTRAINT `JournalCID` FOREIGN KEY (`JournalCID`) REFERENCES `customer` (`CustID`),
  CONSTRAINT `JournalID` FOREIGN KEY (`JournalID`) REFERENCES `journal` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checked_out_journals`
--

LOCK TABLES `checked_out_journals` WRITE;
/*!40000 ALTER TABLE `checked_out_journals` DISABLE KEYS */;
/*!40000 ALTER TABLE `checked_out_journals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checked_out_movies`
--

DROP TABLE IF EXISTS `checked_out_movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `checked_out_movies` (
  `MovieID` int NOT NULL,
  `MovieCID` int NOT NULL,
  `DueDate` varchar(45) NOT NULL,
  `BorrowDate` varchar(45) NOT NULL,
  `OverDueFee` varchar(45) NOT NULL,
  PRIMARY KEY (`MovieID`,`MovieCID`),
  KEY `MovieCID_idx` (`MovieCID`),
  CONSTRAINT `MovieCID` FOREIGN KEY (`MovieCID`) REFERENCES `customer` (`CustID`),
  CONSTRAINT `MovieID` FOREIGN KEY (`MovieID`) REFERENCES `movie` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checked_out_movies`
--

LOCK TABLES `checked_out_movies` WRITE;
/*!40000 ALTER TABLE `checked_out_movies` DISABLE KEYS */;
/*!40000 ALTER TABLE `checked_out_movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `CustID` int NOT NULL,
  `PhoneNum` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  PRIMARY KEY (`CustID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dependant`
--

DROP TABLE IF EXISTS `dependant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dependant` (
  `EID` int NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  PRIMARY KEY (`EID`,`FirstName`),
  CONSTRAINT `EID` FOREIGN KEY (`EID`) REFERENCES `employee` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dependant`
--

LOCK TABLES `dependant` WRITE;
/*!40000 ALTER TABLE `dependant` DISABLE KEYS */;
/*!40000 ALTER TABLE `dependant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `ID` int NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `LastName` varchar(45) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'John','Smith');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journal`
--

DROP TABLE IF EXISTS `journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journal` (
  `ProductID` int NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `JournalAdminID` int NOT NULL,
  `Genre` varchar(45) NOT NULL,
  `Author` varchar(45) NOT NULL,
  `Count` int NOT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `JournalAdminID_idx` (`JournalAdminID`),
  CONSTRAINT `JournalAdminID` FOREIGN KEY (`JournalAdminID`) REFERENCES `admin` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journal`
--

LOCK TABLES `journal` WRITE;
/*!40000 ALTER TABLE `journal` DISABLE KEYS */;
/*!40000 ALTER TABLE `journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movie`
--

DROP TABLE IF EXISTS `movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie` (
  `ProductID` int NOT NULL,
  `Title` varchar(45) NOT NULL,
  `Director` varchar(45) NOT NULL,
  `Length` int NOT NULL,
  `Status` varchar(45) NOT NULL,
  `MovieAdminID` int NOT NULL,
  `Genre` varchar(45) NOT NULL,
  `Count` int NOT NULL,
  PRIMARY KEY (`ProductID`),
  KEY `AdminID_idx` (`MovieAdminID`),
  CONSTRAINT `MovieAdminID` FOREIGN KEY (`MovieAdminID`) REFERENCES `admin` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie`
--

LOCK TABLES `movie` WRITE;
/*!40000 ALTER TABLE `movie` DISABLE KEYS */;
/*!40000 ALTER TABLE `movie` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-11  3:01:05

