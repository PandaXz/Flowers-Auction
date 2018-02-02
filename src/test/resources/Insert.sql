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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id записи адреса',
  `city_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id города',
  `street` varchar(45) NOT NULL COMMENT 'Название улицы',
  `house_number` int(10) unsigned NOT NULL COMMENT 'id города в котором находится адрес',
  PRIMARY KEY (`id`),
  KEY `fk_address_city1_idx` (`city_id_fk`),
  CONSTRAINT `fk_address_city1` FOREIGN KEY (`city_id_fk`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Таблица адресов где находятся цветы, которые продаются на аукционе';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,1,'Lenina',1),(2,1,'Independent',111),(4,2,'Dvornicova',2),(5,2,'Kojara',17);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id записи города',
  `city_name` varchar(45) NOT NULL COMMENT 'Название города',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Таблица городов в которых находятся адреса';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Minsk'),(2,'Homyel'),(3,'Vitebsk'),(4,'Brest');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flowerType`
--

DROP TABLE IF EXISTS `flowerType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flowerType` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id записи цветов',
  `name` varchar(45) NOT NULL COMMENT 'Название цветка. Уникально для каждой записи.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='Таблица цветов доступны для продажи на аукционе';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flowerType`
--

LOCK TABLES `flowerType` WRITE;
/*!40000 ALTER TABLE `flowerType` DISABLE KEYS */;
INSERT INTO `flowerType` VALUES (2,'Romashka'),(1,'Rose'),(3,'Tulip');
/*!40000 ALTER TABLE `flowerType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lot`
--

DROP TABLE IF EXISTS `lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lot` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id записи лота',
  `buyer_id_fk` bigint(20) unsigned DEFAULT NULL COMMENT 'id пользователя предложившего лучшую цену за лот.\nИзначально это id владельца лота.',
  `owner_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id пользователя предложившего лот',
  `flowerType_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id цветов продаваемых в лоте',
  `address_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id адреса, где находятся цветы',
  `start_price` decimal(19,4) unsigned NOT NULL COMMENT 'Стартовая цена лота',
  `current_price` decimal(19,4) unsigned NOT NULL COMMENT 'Текущая цена за лот. \nПользователи которые учавствуют в аукционе могут \nпредложить большую цену.\nПо умолчанию равна начальной цене.',
  `state` char(8) NOT NULL DEFAULT 'ADDED' COMMENT 'Состояние лота. Может быть:\nadded - добавлено. Когда лот только предложени пользователем\ndenied - отказано. Когда администратор отказал в добавлении.\naccepted - добавлено. Когда администратор принял лот.\nunpaid - продан, но не оплачен.\nsold - продано. Когда лот был продан.',
  `count` int(10) unsigned NOT NULL COMMENT 'Количество цветов, продаваемых в лоте',
  `end_datetime` datetime NOT NULL COMMENT 'Время продажи лота',
  `description` text NOT NULL COMMENT 'Описание лота',
  PRIMARY KEY (`id`),
  KEY `fk_lot_user1_idx` (`buyer_id_fk`),
  KEY `fk_lot_user2_idx` (`owner_id_fk`),
  KEY `fk_lot_flower1_idx` (`flowerType_id_fk`),
  KEY `fk_lot_address1_idx` (`address_id_fk`),
  CONSTRAINT `fk_lot_address1` FOREIGN KEY (`address_id_fk`) REFERENCES `address` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lot_flower1` FOREIGN KEY (`flowerType_id_fk`) REFERENCES `flowerType` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lot_user1` FOREIGN KEY (`buyer_id_fk`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lot_user2` FOREIGN KEY (`owner_id_fk`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='Таблица лотов созданных пользователями для аукционов. \nАдминистратор может принять или отклонить лот.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lot`
--

LOCK TABLES `lot` WRITE;
/*!40000 ALTER TABLE `lot` DISABLE KEYS */;
INSERT INTO `lot` VALUES (5,5,6,1,5,40.0000,120.0000,'ACCEPTED',10,'2018-02-01 20:00:00','Rose, blue, natural, pickup'),(8,5,6,1,5,40.0000,120.0000,'UNPAID',10,'2018-02-01 20:00:00','Rose, blue, natural, pickup'),(9,NULL,6,2,5,15.0000,15.0000,'ADDED',7,'2018-02-16 20:00:00','Pickup'),(10,5,6,3,5,80.0000,100.0000,'SOLD',15,'2018-02-01 20:00:00','Pickup'),(11,NULL,5,3,5,40.0000,40.0000,'ACCEPTED',13,'2018-02-16 20:00:00','Pickup'),(12,NULL,6,2,2,100000.0000,100000.0000,'DENIED',9,'2018-02-16 20:00:00','Pickup'),(13,NULL,5,1,5,25.0000,25.0000,'ADDED',12,'2018-02-16 20:00:00','Rose, red, pickup'),(14,5,6,1,2,40.0000,130.0000,'ACCEPTED',3,'2018-02-16 20:00:00','Cool, natural, pickip');
/*!40000 ALTER TABLE `lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lot_story`
--

DROP TABLE IF EXISTS `lot_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lot_story` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id записи',
  `lot_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id лота ',
  `user_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id пользователя',
  `price` decimal(19,4) unsigned NOT NULL COMMENT 'Предложенная цена',
  PRIMARY KEY (`id`),
  KEY `fk_lot_story_lot1_idx` (`lot_id_fk`),
  KEY `fk_lot_story_user1_idx` (`user_id_fk`),
  CONSTRAINT `fk_lot_story_lot1` FOREIGN KEY (`lot_id_fk`) REFERENCES `lot` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lot_story_user1` FOREIGN KEY (`user_id_fk`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Хранит цену предложенную за лот пользователем';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lot_story`
--

LOCK TABLES `lot_story` WRITE;
/*!40000 ALTER TABLE `lot_story` DISABLE KEYS */;
INSERT INTO `lot_story` VALUES (4,10,5,100.0000),(5,8,5,120.0000),(6,14,5,130.0000);
/*!40000 ALTER TABLE `lot_story` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2018-02-02  5:04:52
