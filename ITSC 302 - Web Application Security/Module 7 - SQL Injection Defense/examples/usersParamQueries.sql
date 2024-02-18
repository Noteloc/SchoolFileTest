/*
SQLyog Community v11.28 (64 bit)
MySQL - 5.6.15 : Database - users
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`users` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `users`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`username`,`password`) values ('adam','adam'),('bill','bill');

/* Procedure structure for procedure `buildQuery` */

/*!50003 DROP PROCEDURE IF EXISTS  `buildQuery` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `buildQuery`(theUsername VARCHAR(255))
    MODIFIES SQL DATA
BEGIN
	#Let's dynamically build the statement to run....
	SET @sql = CONCAT('select * from users where username=\'',theUsername,'\';');
	PREPARE sp_getUser FROM @sql;
	EXECUTE sp_getUser;
	DEALLOCATE PREPARE sp_getUser;
	SET @sql=NULL;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `buildQueryQuoted` */

/*!50003 DROP PROCEDURE IF EXISTS  `buildQueryQuoted` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `buildQueryQuoted`(theUsername VARCHAR(255))
    MODIFIES SQL DATA
BEGIN
	#Let's dynamically build the statement to run....
	SET @sql = CONCAT('select * from users where username=',quote(theUsername),';');
	#select @sql;
	PREPARE sp_getUser FROM @sql;
	EXECUTE sp_getUser;
	DEALLOCATE PREPARE sp_getUser;
	SET @sql=NULL;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getUser` */

/*!50003 DROP PROCEDURE IF EXISTS  `getUser` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getUser`(theUsername varchar(20))
BEGIN
	select * from users where username=theUsername;
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getUserQuoted` */

/*!50003 DROP PROCEDURE IF EXISTS  `getUserQuoted` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserQuoted`(theUsername varchar(20))
BEGIN
	select mysql_real_escape_string(theUsername);
    END */$$
DELIMITER ;

/* Procedure structure for procedure `getUserWildcard` */

/*!50003 DROP PROCEDURE IF EXISTS  `getUserWildcard` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `getUserWildcard`(theUsername varchar(20))
BEGIN
	select * from users where username like theUsername;
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
