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
-- Table structure for table `lot_story`
--

DROP TABLE IF EXISTS `lot_story`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lot_story` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id ??????',
  `lot_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id ???? ',
  `user_id_fk` bigint(20) unsigned NOT NULL COMMENT 'id ????????????',
  `price` decimal(19,4) unsigned NOT NULL COMMENT '???????????? ????',
  PRIMARY KEY (`id`),
  KEY `fk_lot_story_lot1_idx` (`lot_id_fk`),
  KEY `fk_lot_story_user1_idx` (`user_id_fk`),
  CONSTRAINT `fk_lot_story_lot1` FOREIGN KEY (`lot_id_fk`) REFERENCES `lot` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lot_story_user1` FOREIGN KEY (`user_id_fk`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='?????? ???? ???????????? ?? ??? ?????????????';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lot_story`
--

LOCK TABLES `lot_story` WRITE;
/*!40000 ALTER TABLE `lot_story` DISABLE KEYS */;
INSERT INTO `lot_story` VALUES (4,10,5,100.0000),(5,8,5,120.0000),(6,14,5,130.0000);
/*!40000 ALTER TABLE `lot_story` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-05 19:07:49
