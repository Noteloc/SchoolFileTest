/*
SQLyog Community v11.3 (64 bit)
MySQL - 5.6.15 : Database - finalproj
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`itsc302finalproj` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `itsc302finalproj`;

/*Table structure for table `accountholders` */

DROP TABLE IF EXISTS `accountholders`;

CREATE TABLE `accountholders` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `locked` binary(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `accountholders` */

insert  into `accountholders`(`username`,`password`,`fullName`,`locked`) values ('adam','adam','Adam Ant','0'),('bill','bill','Bill Gates','0'),('charlie','charlie','Charlie Chaplin','0'),('evil','evil','Evil Bad Person','0');

/*Table structure for table `accounts` */

DROP TABLE IF EXISTS `accounts`;

CREATE TABLE `accounts` (
  `accountID` bigint(20) NOT NULL AUTO_INCREMENT,
  `accountType` varchar(20) NOT NULL,
  `accountBalance` float NOT NULL DEFAULT '0',
  `FK_accountHolder` varchar(20) NOT NULL,
  PRIMARY KEY (`accountID`),
  KEY `holderAccount` (`FK_accountHolder`),
  CONSTRAINT `holderAccount` FOREIGN KEY (`FK_accountHolder`) REFERENCES `accountholders` (`username`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `accounts` */

insert  into `accounts`(`accountID`,`accountType`,`accountBalance`,`FK_accountHolder`) values (1,'chequing',100,'adam'),(2,'savings',100,'adam'),(3,'chequing',200,'bill'),(4,'savings',200,'bill'),(5,'chequing',300,'charlie'),(6,'savings',300,'charlie'),(7,'chequing',0,'evil');

/*Table structure for table `adminusers` */

DROP TABLE IF EXISTS `adminusers`;

CREATE TABLE `adminusers` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `adminusers` */

insert  into `adminusers`(`username`,`password`) values ('admin1','admin1'),('admin2','admin2');

/*Table structure for table `welcome` */

DROP TABLE IF EXISTS `welcome`;

CREATE TABLE `welcome` (
  `welcome` varchar(2000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `welcome` */

insert  into `welcome`(`welcome`) values ('Welcome, ');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
