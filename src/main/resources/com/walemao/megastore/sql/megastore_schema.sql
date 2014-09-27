/*
Navicat MySQL Data Transfer

Source Server         : MyComputer
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : megastore

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2014-09-27 11:39:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `username` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `UK_qh5t4dhrghyroc0clumyg8gx0` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_admin_authorities
-- ----------------------------
DROP TABLE IF EXISTS `t_admin_authorities`;
CREATE TABLE `t_admin_authorities` (
  `username` varchar(64) NOT NULL,
  `authority` varchar(64) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_admin` FOREIGN KEY (`username`) REFERENCES `t_admin` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `o_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `o_u_id` char(36) DEFAULT NULL COMMENT '外键用户id',
  `o_createtime` datetime DEFAULT NULL COMMENT '下单时间',
  `o_addressid` char(36) DEFAULT NULL COMMENT '地址id',
  `o_sid` char(36) DEFAULT NULL COMMENT '确认人id',
  `O_STATE` tinyint(4) DEFAULT NULL COMMENT '订单状态',
  `o_fee` decimal(12,0) DEFAULT NULL COMMENT '订单金额',
  `o_freight` decimal(12,0) DEFAULT NULL COMMENT '运费',
  `o_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `o_paytype` tinyint(4) DEFAULT NULL COMMENT '支付方式',
  `deletemark` datetime DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail` (
  `od_id` char(36) NOT NULL COMMENT '订单记录id',
  `od_productid` char(36) NOT NULL COMMENT '商品id',
  `od_orderid` bigint(20) NOT NULL COMMENT '订单表id',
  `od_amount` int(11) DEFAULT '0' COMMENT '订单数量',
  `od_reamark` varchar(255) DEFAULT NULL COMMENT '备注',
  `deletemark` datetime DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`od_id`),
  KEY `idx_t_order_detail` (`od_productid`,`od_orderid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_persistent_admin_logins
-- ----------------------------
DROP TABLE IF EXISTS `t_persistent_admin_logins`;
CREATE TABLE `t_persistent_admin_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `p_id` char(36) NOT NULL COMMENT '商品id',
  `p_number` varchar(255) DEFAULT NULL COMMENT '商品货号',
  `p_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `p_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `p_price` decimal(10,0) DEFAULT NULL,
  `p_discount` double DEFAULT NULL,
  `deletemark` datetime DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `u_id` char(36) NOT NULL COMMENT '用户id',
  `u_username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `u_password` varchar(255) DEFAULT NULL COMMENT '密码',
  `u_mobilephone` char(11) DEFAULT NULL COMMENT '手机',
  `u_email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `u_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `u_logintime` datetime DEFAULT NULL COMMENT '登录时间',
  `u_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `u_type` tinyint(4) DEFAULT NULL COMMENT '类型',
  `u_level` tinyint(4) DEFAULT NULL,
  `deletemark` datetime DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`u_id`),
  KEY `idx_t_user_1` (`u_type`) USING BTREE,
  KEY `idx_t_user_2` (`u_level`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_base
-- ----------------------------
DROP TABLE IF EXISTS `t_user_base`;
CREATE TABLE `t_user_base` (
  `u_id` char(36) NOT NULL COMMENT '用户id',
  `u_head_portrait` varchar(255) DEFAULT NULL COMMENT '头像',
  `u_nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `u_realname` varchar(50) DEFAULT NULL COMMENT '真实姓名',
  `u_sex` tinyint(4) DEFAULT NULL COMMENT '性别',
  `u_birth` date DEFAULT NULL COMMENT '生日',
  `u_isval_email` tinyint(4) DEFAULT NULL COMMENT '是否严重邮箱',
  `u_provices` tinyint(4) DEFAULT NULL COMMENT '省份',
  `u_cities` smallint(6) DEFAULT NULL COMMENT '城市',
  `u_districts` int(11) DEFAULT NULL COMMENT '地区',
  `u_address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `u_zip_code` smallint(6) DEFAULT NULL COMMENT '邮政编码',
  `u_isval_mobilephone` tinyint(4) DEFAULT NULL COMMENT '是否验证手机',
  `u_telphone` varchar(20) DEFAULT NULL COMMENT '座机',
  PRIMARY KEY (`u_id`),
  UNIQUE KEY `idx_t_user_base_1` (`u_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_user_detail`;
CREATE TABLE `t_user_detail` (
  `u_id` char(36) NOT NULL COMMENT '用户ID',
  `u_matrial_status` tinyint(4) DEFAULT NULL COMMENT '婚姻状况',
  `u_education` tinyint(4) DEFAULT NULL COMMENT '教育程度',
  `u_professional` tinyint(4) DEFAULT NULL COMMENT '从事职业',
  `u_industry` tinyint(4) DEFAULT NULL COMMENT '工作所属行业',
  `u_income` tinyint(4) DEFAULT NULL COMMENT '月均收入',
  `u_interests` varchar(255) DEFAULT NULL COMMENT '兴趣爱好',
  `u_selfdesc` varchar(255) DEFAULT NULL COMMENT '自我介绍',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
