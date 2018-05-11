/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 5.7.21-log : Database - onetouch
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onetouch` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `onetouch`;

/*Table structure for table `ot_registration` */

DROP TABLE IF EXISTS `ot_registration`;

CREATE TABLE `ot_registration` (
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `dob` varchar(15) DEFAULT NULL,
  `phone_no` varchar(15) NOT NULL,
  `email_id` varchar(40) DEFAULT NULL,
  `role` varchar(10) DEFAULT 'customer',
  `profile_pic` varchar(30000) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`phone_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ot_registration` */

insert  into `ot_registration`(`first_name`,`last_name`,`dob`,`phone_no`,`email_id`,`role`,`profile_pic`,`password`,`status`) values 
('santosh','korada',NULL,'9030141625','santuk95@gmail.com','customer',NULL,'H2epDlNLYcjF7LPLRRTZXQ==',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
