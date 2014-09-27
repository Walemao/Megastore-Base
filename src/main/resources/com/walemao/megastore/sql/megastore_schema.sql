/*
Navicat MySQL Data Transfer

Source Server         : MyComputer
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : megastore

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2014-09-27 17:46:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d_cities
-- ----------------------------
DROP TABLE IF EXISTS `d_cities`;
CREATE TABLE `d_cities` (
  `c_key` smallint(6) DEFAULT NULL COMMENT '城市ID',
  `c_value` varchar(255) DEFAULT NULL COMMENT '城市名称',
  `c_pid` tinyint(4) DEFAULT NULL COMMENT '省份ID外键',
  KEY `fk_d_provinces_1` (`c_pid`),
  KEY `c_key` (`c_key`),
  CONSTRAINT `fk_d_provinces_1` FOREIGN KEY (`c_pid`) REFERENCES `d_provinces` (`p_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_districts
-- ----------------------------
DROP TABLE IF EXISTS `d_districts`;
CREATE TABLE `d_districts` (
  `d_key` int(11) NOT NULL COMMENT '地区维表ID',
  `d_value` varchar(255) DEFAULT NULL COMMENT '值',
  `d_pid` smallint(6) DEFAULT NULL COMMENT '外键关联城市维表',
  PRIMARY KEY (`d_key`),
  KEY `fk_d_districts_1` (`d_pid`),
  CONSTRAINT `fk_d_districts_1` FOREIGN KEY (`d_pid`) REFERENCES `d_cities` (`c_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_provinces
-- ----------------------------
DROP TABLE IF EXISTS `d_provinces`;
CREATE TABLE `d_provinces` (
  `p_key` tinyint(4) DEFAULT NULL,
  `p_value` varchar(255) DEFAULT NULL COMMENT '省份名称',
  KEY `p_key` (`p_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user` (
  `ud_id` int(255) NOT NULL COMMENT '用户维表ID',
  `ud_key` int(11) DEFAULT NULL COMMENT 'key值',
  `ud_value` varchar(255) DEFAULT NULL COMMENT '具体值',
  `ud_type` tinyint(4) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`ud_id`),
  KEY `idx_d_user_1` (`ud_type`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_address
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `a_id` char(36) NOT NULL COMMENT '地址ID',
  `a_u_id` char(36) NOT NULL COMMENT '用户ID',
  `a_consignee` char(50) DEFAULT NULL COMMENT '联系人',
  `a_provinces` tinyint(4) DEFAULT NULL COMMENT '省份',
  `a_cities` smallint(6) DEFAULT NULL COMMENT '城市',
  `a_districts` int(11) DEFAULT NULL COMMENT '地区',
  `a_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `a_zip_code` char(6) DEFAULT NULL COMMENT '邮政编码',
  `a_mobilephone` char(11) DEFAULT NULL COMMENT '手机号码',
  `a_phone` char(20) DEFAULT NULL COMMENT '座机',
  `a_isdefault` tinyint(4) DEFAULT NULL COMMENT '是否默认',
  `a_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_complaints
-- ----------------------------
DROP TABLE IF EXISTS `t_complaints`;
CREATE TABLE `t_complaints` (
  `c_id` char(36) NOT NULL COMMENT '投诉咨询表ID',
  `c_subject` tinyint(4) DEFAULT NULL COMMENT '主题选择',
  `c_name` char(20) DEFAULT NULL COMMENT '姓名',
  `c_provinces` tinyint(4) DEFAULT NULL COMMENT '省份',
  `c_cities` smallint(6) DEFAULT NULL COMMENT '城市',
  `c_contact` char(11) DEFAULT NULL COMMENT '联系电话',
  `c_email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `c_orderid` bigint(20) DEFAULT NULL COMMENT '关联订单号',
  `c_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `c_createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_log
-- ----------------------------
DROP TABLE IF EXISTS `t_log`;
CREATE TABLE `t_log` (
  `l_id` bigint(20) NOT NULL COMMENT '日志ID',
  `l_content` varchar(255) DEFAULT NULL COMMENT '日志内容',
  PRIMARY KEY (`l_id`)
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
  `o_state` tinyint(4) DEFAULT NULL COMMENT '订单状态',
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
-- Table structure for t_product_favorites
-- ----------------------------
DROP TABLE IF EXISTS `t_product_favorites`;
CREATE TABLE `t_product_favorites` (
  `pf_id` char(36) NOT NULL COMMENT '收藏表ID',
  `pf_u_id` char(36) NOT NULL COMMENT '用户ID',
  `pf_productid` char(36) NOT NULL COMMENT '商品ID',
  `pf_creattime` datetime DEFAULT NULL COMMENT '创建时间',
  `deletemark` datetime DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`pf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_proposal
-- ----------------------------
DROP TABLE IF EXISTS `t_proposal`;
CREATE TABLE `t_proposal` (
  `P_ID` char(36) NOT NULL,
  `p_u_id` char(36) DEFAULT NULL COMMENT '用户ID',
  `p_subject` tinyint(4) DEFAULT NULL COMMENT '建议留言类型',
  `p_name` char(20) DEFAULT NULL COMMENT '姓名',
  `p_provinces` tinyint(4) DEFAULT NULL COMMENT '省份',
  `p_cities` tinyint(4) DEFAULT NULL COMMENT '城市',
  `p_contact` char(11) DEFAULT NULL COMMENT '联系方式',
  `p_email` varchar(255) DEFAULT NULL COMMENT '电子邮箱',
  `p_content` varchar(255) DEFAULT NULL COMMENT '内容',
  `p_creattime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`P_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping_cart`;
CREATE TABLE `t_shopping_cart` (
  `sc_id` char(36) NOT NULL COMMENT '购物车ID-跟用户ID一致',
  `sc_u_id` char(36) DEFAULT NULL COMMENT '为空表示临时购物车',
  `sc_productid` char(36) DEFAULT NULL,
  `sc_amount` int(11) DEFAULT NULL,
  `deletemark` datetime DEFAULT NULL,
  PRIMARY KEY (`sc_id`)
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

-- ----------------------------
-- Table structure for t_user_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_user_pay`;
CREATE TABLE `t_user_pay` (
  `u_id` char(36) NOT NULL COMMENT '用户ID',
  `u_pay_passwd` varchar(255) DEFAULT NULL COMMENT '支付密码',
  `u_checktype` tinyint(4) DEFAULT NULL COMMENT '验证方式,0是手机，1是邮箱',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;