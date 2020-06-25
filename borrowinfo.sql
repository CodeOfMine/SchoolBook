/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50729
Source Host           : localhost:3306
Source Database       : bookstore

Target Server Type    : MYSQL
Target Server Version : 50729
File Encoding         : 65001

Date: 2020-06-20 21:08:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for borrowinfo
-- ----------------------------
DROP TABLE IF EXISTS `borrowinfo`;
CREATE TABLE `borrowinfo` (
  `userId` int(11) NOT NULL,
  `bookId` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `bookName` varchar(50) NOT NULL,
  `borrowTime` varchar(20) DEFAULT NULL,
  `backTime` varchar(20) DEFAULT NULL,
  `isbn` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  PRIMARY KEY (`userId`,`bookId`),
  KEY `fk_bookId` (`bookId`),
  CONSTRAINT `fk_bookId` FOREIGN KEY (`bookId`) REFERENCES `book` (`bookId`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
