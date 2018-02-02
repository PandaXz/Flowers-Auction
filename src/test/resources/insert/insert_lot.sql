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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-02  5:29:35
