CREATE DATABASE  IF NOT EXISTS `flower_auction_db_test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flower_auction_db_test`;
-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: flower_auction_db_test
-- ------------------------------------------------------
-- Server version	5.7.21-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id записи пользователя',
  `login` varchar(30) NOT NULL COMMENT 'Логин пользователя',
  `password_hash` char(32) NOT NULL COMMENT 'Хэш пароля пользователя',
  `email` varchar(30) NOT NULL COMMENT 'email пользователя',
  `first_name` varchar(50) NOT NULL COMMENT 'Имя пользователя',
  `last_name` varchar(50) NOT NULL COMMENT 'Фамилия пользователя',
  `role` char(5) NOT NULL DEFAULT 'USER' COMMENT 'Роль пользователя. Может содержать \nUSER - для пользователей  \nADMIN - для администратора',
  `balance` decimal(19,4) NOT NULL COMMENT 'Баланс пользователя',
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Таблица пользователей веб-приложения';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'panda','EFE6398127928F1B2E9EF3207FB82663','pandasut.vb@gmail.com','Vlad','Belykh','ADMIN',222.0000),(4,'admin','21232F297A57A5A743894A0E4A801FC3','admin.mail@gmail.com','Admin','Admin','ADMIN',1.0000),(5,'SuperUser','827CCB0EEA8A706C4C34A16891F84E7B','super.user@gmail.com','Super','User','USER',99900.0000),(6,'masha','827CCB0EEA8A706C4C34A16891F84E7B','masha1908@gmail.com','Maria','Syshkina','USER',1100.0000);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-02  5:29:35
