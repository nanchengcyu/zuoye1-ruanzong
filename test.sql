# Host: localhost  (Version: 5.7.26)
# Date: 2023-05-11 15:02:17
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
 `lesson` varchar(50) DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'朱征','软件工程综合实践','98'),(2,'lisi','软件工程综合实践','88'),(3,'wangwu','软件工程综合实践','100'),(4,'qianliu','软件工程综合实践','95');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
