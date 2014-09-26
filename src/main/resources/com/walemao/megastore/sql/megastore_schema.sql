/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : webapp

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2014-03-27 13:28:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_admin` (
   `username` VARCHAR(64) NOT NULL PRIMARY KEY,
   `password` VARCHAR(64) NOT NULL,
   `email` VARCHAR(64) NOT NULL,
   `enabled` BOOLEAN NOT NULL,
  UNIQUE KEY `UK_qh5t4dhrghyroc0clumyg8gx0` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `t_authorities`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_admin_authorities` (
  `username` VARCHAR(64) NOT NULL,
  `authority` VARCHAR(64) NOT NULL,
  CONSTRAINT `fk_authorities_admin` FOREIGN KEY(`username`) REFERENCES t_admin(`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX `ix_auth_username` ON t_admin_authorities (`username`,`authority`);
-- ----------------------------
-- Table structure for `t_persistent_logins`
-- ----------------------------
CREATE TABLE IF NOT EXISTS `t_persistent_admin_logins` (
  `username` VARCHAR(64) NOT NULL,
  `series` VARCHAR(64) PRIMARY KEY,
  `token` VARCHAR(64) NOT NULL,
  `last_used` TIMESTAMP NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

