-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema office_management
--

CREATE DATABASE IF NOT EXISTS office_management;
USE office_management;

--
-- Definition of table `admin_login`
--

DROP TABLE IF EXISTS `admin_login`;
CREATE TABLE `admin_login` (
  `Id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_login`
--

/*!40000 ALTER TABLE `admin_login` DISABLE KEYS */;
INSERT INTO `admin_login` (`Id`,`name`,`password`) VALUES 
 (1,'admin','123'),
 (2,'emran','123'),
 (3,'emon','123');
/*!40000 ALTER TABLE `admin_login` ENABLE KEYS */;


--
-- Definition of table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `fname` varchar(45) NOT NULL,
  `lname` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `district` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `dateofBirth` date NOT NULL,
  `salary` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`id`,`fname`,`lname`,`gender`,`address`,`district`,`country`,`phone`,`email`,`dateofBirth`,`salary`) VALUES 
 (44,'Md. Emran','Hossain','Male','Moghbazar','Dhaka','Bangladesh','01670932273','emranhos1@gmail.com','2016-10-10',20000),
 (45,'Md. Abul','Hasanat','Male','Rampura','Dhaka','Bangladesh','01670932287','abulhasanat@gmail.com','2016-10-04',40000),
 (47,'jharna','Mina','Female','Banassri','Dhaka','Bangladesh','01745322287','jharna@gmail.com','2016-10-04',50000),
 (48,'Helal','Uddin','Male','Banassri','Dhaka','Bangladesh','01745322281','helal@gmail.com','2016-10-04',55000),
 (49,'Md.','Sagor','Male','Malibag','Dhaka','Bangladesh','01732322281','helal@gmail.com','2016-10-04',5000),
 (50,'srimongol','mondol','Male','Moghbazar','Dhaka','Bangladesh','01732122281','srimongol@gmail.com','2016-10-04',10000),
 (54,'Redwan','Hossain','Male','motijhill','Dhaka','Bangladesh','01954757435','aakdf@gmail.com','2016-10-11',7000),
 (57,'Redwan','Hossain','Male','motijhill','Dhaka','Bangladesh','01954757435','aakdf@gmail.com','2016-10-11',8000),
 (59,'Ahamed','sakil','Male','Motijhilllll','Khulna','Bangladesh','01760932287','fhfghfghfjg@gmail.com','2016-10-04',9000),
 (60,'Abu','kalam','Male','Moghbazar','Dhaka','Bangladesh','0198765432','abu@gmail.com','1988-10-31',7500);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `pro_name` varchar(45) NOT NULL,
  `pro_details` varchar(45) NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`,`pro_name`,`pro_details`,`qty`,`price`) VALUES 
 (1,'Genarel(Japan)','Air Conditional',20,70000),
 (2,'Cariar','Air Conditional',10,65000),
 (3,'Neo','Air Conditional',20,55000),
 (12,'Mobile','Android Mobile',40,20000),
 (13,'Mac','iPhone',10,1000000),
 (14,'Mac','Desktop',10,1900000),
 (15,'Mac','Desktop',10,1900000),
 (17,'Watch','Rolex',10,200000),
 (18,'Watch','Rolex',10,200000),
 (19,'T-Shirt','American',20,45000);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
